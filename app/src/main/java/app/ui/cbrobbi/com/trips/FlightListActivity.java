package app.ui.cbrobbi.com.trips;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.api.services.qpxExpress.QPXExpress;
import com.google.api.services.qpxExpress.model.FlightInfo;
import com.google.api.services.qpxExpress.model.LegInfo;
import com.google.api.services.qpxExpress.model.SegmentInfo;
import com.google.api.services.qpxExpress.model.SliceInfo;
import com.google.api.services.qpxExpress.model.TripOption;

import java.util.ArrayList;
import java.util.List;

import utilities.CarOrder;
import utilities.QPXHelper;
import utilities.TempData;

public class FlightListActivity extends AppCompatActivity {

    private ListView listView;
    private Button book_car_btn;
    private boolean showDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);

        listView = (ListView) findViewById(R.id.flight_listview);
        book_car_btn = (Button) findViewById(R.id.book_car);

//        listView.setBackgroundColor(Color.parseColor("#fffcf0"));

        TempData td = TempData.getInstance();
        List<TripOption> tripResult;

        showDefault = getIntent().getBooleanExtra("showDefault", false);

        if (showDefault) {
            tripResult = new ArrayList<>(1);
            tripResult.add(td.tripResult.get(td.curtOrder.getFlightIndex()));

            View footer = getLayoutInflater().inflate(R.layout.fragment_flight_list_footer, null);
            View header = getLayoutInflater().inflate(R.layout.fragment_flight_list_header, null);
            listView.addFooterView(footer);
            listView.addHeaderView(header);
        } else {
            tripResult = td.tripResult;

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(FlightListActivity.this, FlightListActivity.class);

                    TempData td = TempData.getInstance();
                    td.curtOrder.setFlightIndex(position);
                    intent.putExtra("showDefault", true);
                    finish();
                    startActivity(intent);
                }
            });
        }

        listView.setAdapter(new flightListViewAdapter(this.getApplicationContext(), tripResult));

        book_car_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightListActivity.this, CarSearchActivity.class);
                startActivity(intent);
            }
        });

    }

    private class flightListViewAdapter extends ArrayAdapter {

        private List<TripOption> tripResult;
        private Context context;

        private TempData td;

        public flightListViewAdapter(Context context, List<TripOption> tripResult) {
            super(context, -1, tripResult);

            this.context = context;
            this.tripResult = tripResult;

            TempData td = TempData.getInstance();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.rowlayout_flight_list, parent, false);

            TextView carrier = (TextView) rowView.findViewById(R.id.carrier);
            TextView departure_time = (TextView) rowView.findViewById(R.id.flight_list_departure_time);
            TextView arrival_time = (TextView) rowView.findViewById(R.id.flight_list_arrival_time);
            TextView departure_city = (TextView) rowView.findViewById(R.id.flight_list_departure_city);
            TextView arrival_city = (TextView) rowView.findViewById(R.id.flight_list_arrival_city);
            TextView price = (TextView) rowView.findViewById(R.id.flight_price);

            TripOption option = tripResult.get(position);

            QPXHelper qpxHelper = new QPXHelper(option);

            carrier.setText(qpxHelper.getCarrier());
            departure_time.setText(qpxHelper.getDeparture_time());
            arrival_time.setText(qpxHelper.getArrival_time());
            departure_city.setText(qpxHelper.getDeparture_city());
            arrival_city.setText(qpxHelper.getArrival_city());
            price.setText(qpxHelper.getPrice());

            return rowView;
        }
    }

    public void startFullList (View view) {
        Intent intent = new Intent(this.getApplicationContext(), FlightListActivity.class);
        //show full list
        intent.putExtra("showDefault", false);

        startActivity(intent);
    }
}
