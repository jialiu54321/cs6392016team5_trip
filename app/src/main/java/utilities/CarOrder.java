package utilities;


import android.util.Log;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jialiu on 3/20/17.
 */

public class CarOrder {

    private CarData.CarType carType;
    private Car car;
    private Date pickupDate;
    private Date dropoffDate;

    public CarOrder() {
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarData.CarType getCarType() {
        return carType;
    }

    public void setCarType(CarData.CarType carType) {
        this.carType = carType;
    }

    public int getDays() {
        long diff = dropoffDate.getTime() - pickupDate.getTime();
        Log.i("Days: ", diff + "");
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
