package utilities;

import com.google.api.services.qpxExpress.model.TripOption;

import java.util.List;

/**
 * Created by jialiu on 2/20/17.
 *
 * Global variables are stored here.
 */

public class TempData {

    private static TempData instance;

    private TempData() {
        adult_num = 1;
        child_num = 0;
    }

    public static synchronized TempData getInstance(){
        if(instance == null){
            instance = new TempData();
        }
        return instance;
    }

    public List<TripOption> tripResult;
    public Order curtOrder;
    public int adult_num;
    public int child_num;
}
