package app.ui.cbrobbi.com.trips;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import utilities.Car;
import utilities.CarData;
import utilities.TempData;

public class CarListActivity extends AppCompatActivity {

    private ListView listView;
    private TempData td;
    private CarData cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_list);

        td = TempData.getInstance();
        cd = CarData.getInstance();

        listView = (ListView) findViewById(R.id.car_listview);

        ArrayList<Car> carList = cd.getCarMap().get(td.curtOrder.getCarOrder().getCarType());
        Log.i("getCarType", td.curtOrder.getCarOrder().getCarType().getName());
        Log.i("carList", carList.size() + "");
        listView.setAdapter(new CarListViewAdapter(this.getApplicationContext(), -1, carList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }

    private class CarListViewAdapter extends ArrayAdapter {

        private Context context;
        List<Car> cars;

        public CarListViewAdapter(Context context, int resource, List<Car> cars) {
            super(context, resource, cars);
            this.context = context;

            this.cars = cars;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.rowlayout_car_list, parent, false);

            ImageView carImg = (ImageView) rowView.findViewById(R.id.car_list_img);
            TextView car_list_info = (TextView) rowView.findViewById(R.id.car_list_info);
            TextView car_list_price = (TextView) rowView.findViewById(R.id.car_list_price);

            Car car = cars.get(position);

            Log.i("car.getCarImg()", car.getCarImg() + "");
            if (car.getCarImg() != 0) {
                carImg.setBackground(context.getDrawable(car.getCarImg()));
            } else {
                carImg.setBackground(context.getDrawable(R.drawable.luxury_convertible_bmw4series));
            }
//            carImg.setImageResource(car.getCarImg());
            car_list_info.setText(car.getCarBrand().getName() + " " + car.getCarModel().getName());
            car_list_price.setText("$" + car.getPrice() + ".00 / Day");

            return rowView;
        }
    }
}
