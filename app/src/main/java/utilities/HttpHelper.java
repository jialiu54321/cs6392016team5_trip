package utilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jialiu on 2/19/17.
 */

public class HttpHelper {

    static String googleQPXApiKey = "AIzaSyDSZXYTcmF-tgYIquyehnat0PveJ4GZyB8";
    static String flightSearchURLString = "https://www.googleapis.com/qpxExpress/v1/trips/search";

    public void flightSearchHttpRequest() {

        HttpURLConnection flightSearchClient = null;

        try {
            URL flightSearchURL = new URL(flightSearchURLString + "?" + "key=" + googleQPXApiKey);
            flightSearchClient = (HttpURLConnection) flightSearchURL.openConnection();

            flightSearchClient.setDoOutput(true);
            flightSearchClient.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            flightSearchClient.setRequestProperty("Accept", "application/json");
            flightSearchClient.setRequestMethod("POST");

            flightSearchClient.connect();

            //prepare JSON
            JSONObject json = new JSONObject();
            JSONObject requestJSON = new JSONObject();
            JSONArray sliceJSONArray = new JSONArray();

            JSONObject sliceInputJSON = new JSONObject();
            sliceInputJSON.put("kind", "qpxexpress#sliceInput");
            sliceInputJSON.put("origin", "SFO");
            sliceInputJSON.put("destination", "JFK");
            sliceInputJSON.put("date", "2017-02-21");

            JSONObject passengersJSON = new JSONObject();
            passengersJSON.put("adultCount", 1);
            passengersJSON.put("infantInLapCount", 0);
            passengersJSON.put("infantInSeatCount", 0);
            passengersJSON.put("childCount", 0);
            passengersJSON.put("seniorCount", 0);

            json.put("request", requestJSON);
            requestJSON.put("slice", sliceJSONArray);
            sliceJSONArray.put(sliceInputJSON);
            requestJSON.put("passengers", passengersJSON);
            requestJSON.put("solutions", 20);
            requestJSON.put("refundable", false);

            Log.v("HttpHelper", json.toString());

            OutputStreamWriter wr = new OutputStreamWriter(flightSearchClient.getOutputStream());
            //send JSON
            wr.write(json.toString());
            wr.flush();
            wr.close();

            BufferedReader serverAnswer = new BufferedReader(new InputStreamReader(flightSearchClient.getInputStream(), "utf-8"));
            Log.v("serverAnswer", serverAnswer.toString());

            wr.close();
            serverAnswer.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error: Cannot Estabilish Connection");
        } finally {
            if (flightSearchClient != null) flightSearchClient.disconnect();
        }
    }

}
