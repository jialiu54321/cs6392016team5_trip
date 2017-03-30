package app.ui.cbrobbi.com.trips;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import utilities.CarData;
import utilities.CarOrder;
import utilities.TempData;

public class CarSearchActivity extends AppCompatActivity {

    private int pickupYear, pickupMonth, pickupDay;
    private int dropoffYear, dropoffMonth, dropoffDay;
    private Calendar calendar;

    private TextView pickup_date_selected;
    private Button pickup_date_btn;
    private TextView dropoff_date_selected;
    private Button dropoff_date_btn;
    private Spinner car_type_spinner;

    private Button search_car;

    private TempData td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_search);

        td = TempData.getInstance();

        pickup_date_selected = (TextView) findViewById(R.id.pickup_date_selected);
        pickup_date_btn = (Button) findViewById(R.id.pickup_date_btn);
        dropoff_date_selected = (TextView) findViewById(R.id.dropoff_date_selected);
        dropoff_date_btn = (Button) findViewById(R.id.dropoff_date_btn);

        search_car = (Button) findViewById(R.id.search_car);

        car_type_spinner = (Spinner) findViewById(R.id.car_type_spinner);
        car_type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("car_type_spinner", position + "");
                switch (position) {
                    case 0: td.curtOrder.getCarOrder().setCarType(CarData.CarType.MINI);
                        break;
                    case 1: td.curtOrder.getCarOrder().setCarType(CarData.CarType.ECONOMY);
                        break;
                    case 2: td.curtOrder.getCarOrder().setCarType(CarData.CarType.COMPACT);
                        break;
                    case 3: td.curtOrder.getCarOrder().setCarType(CarData.CarType.MIDSIZE);
                        break;
                    case 4: td.curtOrder.getCarOrder().setCarType(CarData.CarType.STANDARD);
                        break;
                    case 5: td.curtOrder.getCarOrder().setCarType(CarData.CarType.FULLSIZE);
                        break;
                    case 6: td.curtOrder.getCarOrder().setCarType(CarData.CarType.PREMIUM);
                        break;
                    case 7: td.curtOrder.getCarOrder().setCarType(CarData.CarType.LUXURY);
                        break;
                    case 8: td.curtOrder.getCarOrder().setCarType(CarData.CarType.CONVERTIBLE);
                        break;
                    case 9: td.curtOrder.getCarOrder().setCarType(CarData.CarType.SUV);
                        break;
                    default: td.curtOrder.getCarOrder().setCarType(CarData.CarType.STANDARD);
                }
                Log.i("car_type_spinner_type", td.curtOrder.getCarOrder().getCarType().getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                td.curtOrder.getCarOrder().setCarType(CarData.CarType.STANDARD);
            }
        });

        calendar = Calendar.getInstance();
        pickupYear = calendar.get(Calendar.YEAR);
        pickupMonth = calendar.get(Calendar.MONTH);
        pickupDay = calendar.get(Calendar.DAY_OF_MONTH);
        pickup_date_selected.setText(formatDate(new Date(pickupYear, pickupMonth + 1, pickupDay)));
        dropoffYear = calendar.get(Calendar.YEAR);
        dropoffMonth = calendar.get(Calendar.MONTH);
        dropoffDay = calendar.get(Calendar.DAY_OF_MONTH);
        dropoff_date_selected.setText(formatDate(new Date(pickupYear, pickupMonth + 1, pickupDay)));

        search_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarSearchActivity.this, CarListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setPickupDate(View view) {
        showDialog(1);
        Toast.makeText(getApplicationContext(), "Choose a pick up date!", Toast.LENGTH_SHORT)
                .show();
    }

    public void setDropoffDate(View view) {
        showDialog(2);
        Toast.makeText(getApplicationContext(), "Choose a pick up date!", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 1) {
            return new DatePickerDialog(this, myPickupDateListener, pickupYear, pickupMonth, pickupDay);
        }
        else if (id == 2)
        {
            return new DatePickerDialog(this, myDropoffDateListener, dropoffYear, dropoffMonth, dropoffDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myPickupDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            Date d = new Date(arg1, arg2 + 1, arg3);
            td.curtOrder.getCarOrder().setPickupDate(d);
            pickup_date_selected.setText(formatDate(d));
        }
    };

    private DatePickerDialog.OnDateSetListener myDropoffDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            Date d = new Date(arg1, arg2 + 1, arg3);
            td.curtOrder.getCarOrder().setDropoffDate(d);
            dropoff_date_selected.setText(formatDate(d));
        }
    };

    private String formatDate(Date d) {
        return new StringBuilder().append(d.getYear()).append("-").append(d.getMonth()).append("-").append(d.getDate()).toString();
    }
}
