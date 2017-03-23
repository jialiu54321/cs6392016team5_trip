package utilities;

/**
 * Created by jialiu on 3/19/17.
 */

public class Order {

    //index for tripResult
    private int flightIndex;
    private CarOrder carOrder;

    public Order(int flightIndex) {
        this.flightIndex = flightIndex;
        this.carOrder =  new CarOrder();
    }

    public int getFlightIndex() {
        return flightIndex;
    }

    public void setFlightIndex(int flightIndex) {
        this.flightIndex = flightIndex;
    }

    public CarOrder getCarOrder() {
        return carOrder;
    }

    public void setCarOrder(CarOrder carOrder) {
        this.carOrder = carOrder;
    }
}
