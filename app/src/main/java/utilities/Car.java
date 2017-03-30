package utilities;

/**
 * Created by jialiu on 3/22/17.
 */

public class Car {
    private CarData.CarType carType;
    private CarData.CarBrand carBrand;
    private CarData.CarModel carModel;
    private int carImg;
    private int price;

    public Car(CarData.CarBrand carBrand, int carImg, CarData.CarModel carModel, CarData.CarType carType, int price) {
        this.carBrand = carBrand;
        this.carImg = carImg;
        this.carModel = carModel;
        this.carType = carType;
        this.price = price;
    }

    public CarData.CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarData.CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarImg() {
        return carImg;
    }

    public void setCarImg(int carImg) {
        this.carImg = carImg;
    }

    public CarData.CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarData.CarModel carModel) {
        this.carModel = carModel;
    }

    public CarData.CarType getCarType() {
        return carType;
    }

    public void setCarType(CarData.CarType carType) {
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
