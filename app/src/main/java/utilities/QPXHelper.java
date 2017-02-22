package utilities;

import com.google.api.services.qpxExpress.model.FlightInfo;
import com.google.api.services.qpxExpress.model.LegInfo;
import com.google.api.services.qpxExpress.model.SegmentInfo;
import com.google.api.services.qpxExpress.model.SliceInfo;
import com.google.api.services.qpxExpress.model.TripOption;

import java.util.List;

/**
 * Created by jialiu on 2/20/17.
 */

public class QPXHelper {

    private TripOption option;
    private String carrier;
    private String departure_time;
    private String arrival_time;
    private String departure_city;
    private String arrival_city;
    private String price;

    public QPXHelper(TripOption option) {

        this.option = option;

        //A slice represents a traveller's intent, the portion of a low-fare search corresponding to a traveler's
        // request to get between two points. One-way journeys are generally expressed using 1 slice, round-trips using 2
        List<SliceInfo> sliceInfo = option.getSlice();

        //a segment is one or more consecutive legs on the same flight
        List<SegmentInfo> segInfoFirst = sliceInfo.get(0).getSegment();
        List<SegmentInfo> segInfoLast = sliceInfo.get(sliceInfo.size() - 1).getSegment();

        FlightInfo flightInfoFirst = segInfoFirst.get(0).getFlight();
        FlightInfo flightInfoLast = segInfoLast.get(segInfoLast.size() - 1).getFlight();

        String carrierFirst = flightInfoFirst.getCarrier().toString();
        String carrierLast = flightInfoLast.getCarrier().toString();
        if (carrierFirst.equals(carrierLast)) {
            this.carrier = carrierFirst;
        } else {
            this.carrier = "Mix";
        }

        List<LegInfo> leg = segInfoFirst.get(0).getLeg();
        String[] departure_time_strings = leg.get(0).getDepartureTime().split("T");
        departure_time = departure_time_strings[0] + " " + departure_time_strings[departure_time_strings.length - 1].split("-")[0];
        String[] arrival_time_strings = leg.get(leg.size() - 1).getArrivalTime().split("T");
        arrival_time = arrival_time_strings[0] + " " + departure_time_strings[departure_time_strings.length - 1].split("-")[1];
        departure_city = leg.get(0).getOrigin();
        arrival_city = leg.get(0).getDestination();
        price = option.getSaleTotal().replace("USD", "$");
    }

    public String getCarrier() {
        return carrier;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public String getPrice() {
        return price;
    }
}
