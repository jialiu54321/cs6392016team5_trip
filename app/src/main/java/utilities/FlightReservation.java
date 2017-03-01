package utilities;

import android.util.Log;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.qpxExpress.QPXExpress;
import com.google.api.services.qpxExpress.QPXExpressRequestInitializer;
import com.google.api.services.qpxExpress.model.PassengerCounts;
import com.google.api.services.qpxExpress.model.SliceInput;
import com.google.api.services.qpxExpress.model.TripOption;
import com.google.api.services.qpxExpress.model.TripOptionsRequest;
import com.google.api.services.qpxExpress.model.TripsSearchRequest;
import com.google.api.services.qpxExpress.model.TripsSearchResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialiu on 2/19/17.
 */

public class FlightReservation {

    private static final String APPLICATION_NAME = "TripMaster";

    private static final String API_KEY = "AIzaSyDSZXYTcmF-tgYIquyehnat0PveJ4GZyB8";

    /** Global instance of the HTTP transport. */
    private static HttpTransport httpTransport;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static List<TripOption> reserve(TripOptionsRequest request) {
        try {
            httpTransport = new NetHttpTransport();

//            PassengerCounts passengers = new PassengerCounts();
//            passengers.setAdultCount(1);
//
//            List<SliceInput> slices = new ArrayList<>();
//            SliceInput slice = new SliceInput();
//            slice.setOrigin("NYC");
//            slice.setDestination("SFO");
//            slice.setDate("2017-02-21");
//            slices.add(slice);
//
//            TripOptionsRequest request = new TripOptionsRequest();
//            request.setSolutions(20);
//            request.setPassengers(passengers);
//            request.setSlice(slices);

            TripsSearchRequest parameters = new TripsSearchRequest();
            parameters.setRequest(request);
            QPXExpress qpxExpress = new QPXExpress.Builder(httpTransport, JSON_FACTORY, null).setApplicationName(APPLICATION_NAME).setQPXExpressRequestInitializer(new QPXExpressRequestInitializer(API_KEY)).build();

            TripsSearchResponse list = qpxExpress.trips().search(parameters).execute();
            List<TripOption> tripResult = list.getTrips().getTripOption();

            if (tripResult == null || tripResult.size() == 0) {
                Log.v("FlightReservation", "search failed");
            } else {
                Log.v("FlightReservation", tripResult.get(0).toString());
            }

            return tripResult;

        } catch (Exception e) {
            e.printStackTrace();
            Log.v("FlightReservation", "Error: Cannot Estabilish Connection");
        }

        return null;
    }

}
