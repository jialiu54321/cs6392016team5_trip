package app.ui.cbrobbi.com.trips;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.AppBarLayout.LayoutParams;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import android.widget.Button;


public class ImDoneActivity extends AppCompatActivity {
    ArrayList<Date> dates =new ArrayList();
    ArrayList<Integer> ids =new ArrayList();
    ArrayList<Integer> myList_nights_int = new ArrayList();
    ArrayList<Integer> layout_num = new ArrayList();
    int k;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_done);

        LinearLayout parent_layout = (LinearLayout) findViewById(R.id.parent_layout);
        LinearLayout parent_layout1 = (LinearLayout) findViewById(R.id.parent_layout2);


        String departure_city_entry = getIntent().getExtras().getString("departure_city");

        String cabin_class_entry = getIntent().getExtras().getString("cabin_class");

        String rooms_num_entry = getIntent().getExtras().getString("rooms_num");

        String arriving_city_entry = getIntent().getExtras().getString("arriving_city");

        String selected_date_entry = getIntent().getExtras().getString("selected_date");

        String adults_num_entry = Integer.toString(getIntent().getExtras().getInt("adults_number"));

        String children_num_entry = Integer.toString(getIntent().getExtras().getInt("children_number"));

        String nights_num_entry = Integer.toString(getIntent().getExtras().getInt("nights_number"));

        TextView adults_num = (TextView) findViewById(R.id.adults_num);
        TextView children_num = (TextView) findViewById(R.id.children_num);
        adults_num.setText("for " + adults_num_entry + " Adult(s), ");
        children_num.setText(children_num_entry + " Child(ren)");

        TextView deparure_city = (TextView) findViewById(R.id.departure_city);
        deparure_city.setText(departure_city_entry  + " , US");
        TextView arrival_city2 = (TextView) findViewById(R.id.arrival_city2 );
        arrival_city2.setText(departure_city_entry+ " , Peru");

        TextView deparure_city2 = (TextView) findViewById(R.id.departure_city2 );
        deparure_city2.setText(arriving_city_entry+ " , Peru");
        TextView arrival_city = (TextView) findViewById(R.id.arrival_city);
        arrival_city.setText(arriving_city_entry + " , US");


        String allItems = "";
        ArrayList<String> myList_nights = (ArrayList<String>) getIntent().getSerializableExtra("mylist_nights");
        //for (String night : myList_nights) {
        // allItems = allItems + "\n" + night; //adds a new line between items
        // data.setText(allItems);
        //}


        ArrayList<String> myList_cities = (ArrayList<String>) getIntent().getSerializableExtra("mylist_cities");

        myList_cities.add(0,arriving_city_entry);


        //Toast.makeText(getApplicationContext(), allItems, Toast.LENGTH_LONG).show();


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String start_date = selected_date_entry.toString();

        for (String s : myList_nights) {
            myList_nights_int.add(Integer.valueOf(s));
        }

        int[] dd = convertIntegers(myList_nights_int);

        for (int i = 0; i < myList_nights.size(); i++) {


            try {

                Date date = formatter.parse(start_date);
                //Toast.makeText(getApplicationContext(), date.toString(), Toast.LENGTH_SHORT).show();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, sumOfArray(dd, i));
                Date dt = c.getTime();
                dates.add(dt);

               // Toast.makeText(getApplicationContext(), dt.toString(), Toast.LENGTH_SHORT).show();

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        try {

            Date date2 = formatter.parse(start_date);
            dates.add(0,date2);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }



        LinearLayout parent_layout2 = (LinearLayout) findViewById(R.id.parent_layout2);

        for (int i = 0; i < myList_cities.size(); i++) {

            TextView city_date = new TextView(this);
            city_date.setId(i);
            LayoutParams city_date_params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            city_date.setTypeface(null, Typeface.BOLD);
            city_date.setTextSize(30);


            city_date.setLayoutParams(city_date_params);
            String date1 = dates.get(i).toString();
            String date2 = dates.get(i + 1).toString();
            city_date.setText((date1.substring(0, 10)) + " - " + (date2.substring(0, 10)) + " " + (date2.substring(24, 28)));
            city_date.setTextColor(Color.parseColor("#d38d06"));
            parent_layout2.addView(city_date);

            LinearLayout LH1 = new LinearLayout(this);
            LH1.setOrientation(LinearLayout.HORIZONTAL);
            LayoutParams LHParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LH1.setLayoutParams(LHParams);


            LinearLayout LV11 = new LinearLayout(this);
            LV11.setOrientation(LinearLayout.VERTICAL);
            LayoutParams LV11Params = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LV11Params.weight = 7f;
            LV11.setLayoutParams(LV11Params);
            LinearLayout LV22 = new LinearLayout(this);
            LV22.setOrientation(LinearLayout.VERTICAL);
            LayoutParams LV22Params = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LV22Params.weight = 3f;
            LV22.setLayoutParams(LV22Params);


            TextView city = new TextView(this);
            LayoutParams city_params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            city.setTypeface(null, Typeface.BOLD);
            city_date.setTextSize(25);
            city.setTextSize(25);
            city.setTextColor(Color.parseColor("#1A237E"));
            city.setLayoutParams(city_params);
            city.setId(i);
            parent_layout2.addView(city);
            city.setText(myList_cities.get(i));

            TextView hotel_desc = new TextView(this);
            hotel_desc.setId(i);
            LayoutParams hotel_desc_params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            hotel_desc.setTypeface(null, Typeface.BOLD);
            hotel_desc.setTextSize(20);
            hotel_desc.setTextColor(Color.parseColor("#0065b8"));
            hotel_desc.setText("Accomodation");
            hotel_desc.setBackgroundColor(700);
            hotel_desc.setLayoutParams(hotel_desc_params);


            parent_layout2.addView(hotel_desc);


            TextView default_hotel = new TextView(this);
            LayoutParams default_hotel_params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

            default_hotel.setId(i);
            default_hotel.setLayoutParams(default_hotel_params);

            String city_name = city.getText().toString();


            parent_layout2.addView(LH1);
            LH1.addView(LV11);
            LH1.addView(LV22);


            final Button upgrade_hotel_button = new Button(this);
            LayoutParams add_hotel_button_params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            upgrade_hotel_button.setBackgroundResource(R.drawable.button_design);
            upgrade_hotel_button.setText("Upgrade");
            upgrade_hotel_button.setTextColor(Color.parseColor("#FFFFFF"));
            upgrade_hotel_button.setLayoutParams(add_hotel_button_params);
            upgrade_hotel_button.setId(i);
            LV22.addView(upgrade_hotel_button);
            LV11.addView(default_hotel);

            switch (city_name) {
                case "Lima":
                    default_hotel.setText("Hotel Sheraton - Lima");
                    break;
                case "Puno":
                    default_hotel.setText("Tierra Viva Puno Plaza Hotel");
                    break;
                case "Cuzco":
                    default_hotel.setText("Hotel Rumi Punku");
                    break;
                case "Nazca":
                    default_hotel.setText("Casa Hacienda Nasca Oasis");
                    break;
                case "Arequipa":
                    default_hotel.setText("Hotel Libertador Arequipa");
                    break;
                case "Iquitos":
                    default_hotel.setText("Hotel Sol del Oriente Iquitos");
                    break;
                case "Ica":
                    default_hotel.setText("Hotel Las Flores");
                    break;

            }


            TextView act_desc = new TextView(this);
            hotel_desc.setId(i);
            LayoutParams act_desc_params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            act_desc.setTypeface(null, Typeface.BOLD);
            act_desc.setTextSize(20);
            act_desc.setLayoutParams(hotel_desc_params);
            act_desc.setText("Activities");
            act_desc.setTextColor(Color.parseColor("#0065b8"));
            parent_layout2.addView(act_desc);


            String upgrade = getIntent().getExtras().getString("upgrade");
            int b_id = getIntent().getExtras().getInt("id_b");
            Toast.makeText(getApplicationContext(), Integer.toString(b_id), Toast.LENGTH_LONG).show();



            if (b_id>222) {
                default_hotel.setText("test");

            }



        upgrade_hotel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int k=upgrade_hotel_button.getId();

                Toast.makeText(getApplicationContext(), Integer.toString(k), Toast.LENGTH_LONG).show();
                Intent upgradeHotelIntent = new Intent(ImDoneActivity.this, HotelUpgradeActivity.class);
                upgradeHotelIntent.putExtra("id", k);
                ImDoneActivity.this.startActivity(upgradeHotelIntent);



            }
        });

            double totals = (Integer.parseInt(adults_num_entry)+((Integer.parseInt(children_num_entry)*0.8))*650+((Integer.parseInt(adults_num_entry)+((Integer.parseInt(children_num_entry)*0.8))*sumOfArray(dd,myList_nights.size()-1))));
            DecimalFormat df = new DecimalFormat("#,###.00");

            TextView total = (TextView) findViewById(R.id.total);
            total.setText("$ "+ df.format(totals));

            TextView total_per_person = (TextView) findViewById(R.id.total_per_person);
            int people=(Integer.parseInt(children_num_entry)+Integer.parseInt(adults_num_entry));
            double pp=totals/people;
            total_per_person.setText("$ "+ df.format(pp));

    }}

    public void upgrade_hotel() {

        Intent upgradeHotelIntent = new Intent(this, HotelUpgradeActivity.class);
        upgradeHotelIntent.putExtra("id", k);
        startActivity(upgradeHotelIntent);


    }




    public int sumOfArray(int[] a, int n) {
        if (n == 0){
            return a[n];}
        else{
            return a[n] + sumOfArray(a, n-1);}




    }



    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }




}
