package utilities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.services.qpxExpress.model.TripOption;
import com.google.api.services.qpxExpress.model.TripOptionsRequest;

import java.util.List;

import app.ui.cbrobbi.com.trips.FlightListActivity;

/**
 * Created by jialiu on 2/19/17.
 */

public class FlightSearch extends AsyncTask<TripOptionsRequest, Void, List<TripOption>> {

    Context context;
    public FlightSearch(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected List<TripOption> doInBackground(TripOptionsRequest... params) {
        return FlightReservation.reserve(params[0]);
    }

    @Override
    protected void onPostExecute(List<TripOption> tripResult) {
        super.onPostExecute(tripResult);

        if (tripResult == null || tripResult.size() == 0) {
            Toast.makeText(context, "Please Retry", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent flightListIntent = new Intent(context.getApplicationContext(), FlightListActivity.class);
        //show only one item (the default item) in the list, the first item of the search result is the used as default
        flightListIntent.putExtra("showDefault", true);

        TempData td = TempData.getInstance();

        td.curtOrder = new Order(0);
        td.tripResult = tripResult;

        context.startActivity(flightListIntent);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Toast.makeText(context, "Searching...", Toast.LENGTH_LONG).show();
    }
}
