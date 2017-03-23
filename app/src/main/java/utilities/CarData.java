package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import app.ui.cbrobbi.com.trips.R;

/**
 * Created by jialiu on 3/20/17.
 */

public class CarData {

    public enum CarType {
        MINI("Mini", 0),
        ECONOMY("Economy", 1),
        COMPACT("Compact", 2),
        MIDSIZE("Midsize", 3),
        STANDARD("Standard", 4),
        FULLSIZE("Full Size", 5),
        PREMIUM("Premium", 6),
        LUXURY("Luxury", 7),
        CONVERTIBLE("Convertible", 8),
        SUV("SUV", 9);

        private String name;
        private int id;

        CarType(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    public enum CarBrand {
        FORD("Ford"),
        NISSAN("Nissan"),
        TOYOTA("Toyota"),
        CHEVROLET("Chevrolet"),
        HYUNDAI("Hyundai"),
        MITSUBISHI("Mitsubishi"),
        CADILLAC("Cadillac"),
        CHRYSLER("Chrysler"),
        SMART("Smart"),
        DODGE("Dodge"),
        MERCEDESBENZ("Mercedes Benz"),
        BUICK("Buick"),
        VOLKSWAGEN("Volkswagen"),
        BMW("BMW"),
        Audi("Audi");

        private String name;

        CarBrand(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum CarModel {
        FOCUS("Focus"),
        VERSA("Versa"),
        PRIUS("Prius"),
        SPARK("Spark"),
        FIESTA("Fiesta"),
        ACCENT("Accent"),
        MIRAGE("Mirage"),
        YARIS("Yaris"),
        MALIBU("Malibu"),
        FUSION("Fusion"),
        ALTIMA("Altima"),
        CAMRY("Camry"),
        XTS("XTS"),
        CHRYSLER300("300"),
        BMW4SERIES("4 Series"),
        GLC("GLC"),
        A4("A4"),
        CRUZE("Cruze"),
        ELANTRA("Elantra"),
        COROLLA("Corolla"),
        FORTWO("Fortwo"),
        CHARGER("Charger"),
        CHEVYCAMARO("ChevyCamaro"),
        TAURUS("Taurus"),
        CLA("CLA"),
        MAXIMA("Maxima"),
        VERANO("Verano"),
        CHRYSLER200("200"),
        MUSTANG("Mustang"),
        SONATA("Sonata"),
        TRAVERSE("Traverse"),
        EDGE("Edge"),
        SANTAFE("SantaFe"),
        JETTA("Jetta");

        private String name;

        CarModel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private HashMap<CarType, ArrayList<Car>> carMap;

    private static CarData instance;

    private CarData() {
        carMap = new HashMap<CarType, ArrayList<Car>>();

        Random rand = new Random();
        int min = 20;
        int max = 30;

        ArrayList<Car> miniList = new ArrayList<Car>();
        miniList.add(new Car(CarBrand.SMART,  R.drawable.mini_smart_fortwo, CarModel.FORTWO, CarType.MINI, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.MINI, miniList);

        min = 30;
        max = 50;
        ArrayList<Car> economyList = new ArrayList<Car>();
        economyList.add(new Car(CarBrand.CHEVROLET, R.drawable.economy_chevrolet_spark, CarModel.SPARK, CarType.ECONOMY, rand.nextInt((max - min) + 1) + min));
        economyList.add(new Car(CarBrand.TOYOTA, R.drawable.economy_toyota_yaris, CarModel.YARIS, CarType.ECONOMY, rand.nextInt((max - min) + 1) + min));
        economyList.add(new Car(CarBrand.FORD, R.drawable.economy_ford_fiesta, CarModel.FIESTA, CarType.ECONOMY, rand.nextInt((max - min) + 1) + min));
        economyList.add(new Car(CarBrand.MITSUBISHI, R.drawable.economy_mitsubishi_mirage, CarModel.MIRAGE, CarType.ECONOMY, rand.nextInt((max - min) + 1) + min));
        economyList.add(new Car(CarBrand.HYUNDAI, R.drawable.economy_hyundai_accent, CarModel.ACCENT, CarType.ECONOMY, rand.nextInt((max - min) + 1) + min));
        economyList.add(new Car(CarBrand.CHEVROLET, R.drawable.economy_chevrolet_spark, CarModel.SPARK, CarType.ECONOMY, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.ECONOMY, economyList);

        min = 35;
        max = 55;
        ArrayList<Car> compactList = new ArrayList<Car>();
        compactList.add(new Car(CarBrand.FORD, R.drawable.compact_ford_focus, CarModel.FOCUS, CarType.COMPACT, rand.nextInt((max - min) + 1) + min));
        compactList.add(new Car(CarBrand.NISSAN, R.drawable.compact_nissan_versa, CarModel.VERSA, CarType.COMPACT, rand.nextInt((max - min) + 1) + min));
        compactList.add(new Car(CarBrand.TOYOTA, R.drawable.compact_toyota_prius, CarModel.PRIUS, CarType.COMPACT, rand.nextInt((max - min) + 1) + min));
        compactList.add(new Car(CarBrand.TOYOTA, R.drawable.compact_toyota_yaris, CarModel.YARIS, CarType.COMPACT, rand.nextInt((max - min) + 1) + min));
        compactList.add(new Car(CarBrand.FORD, R.drawable.compact_ford_focus, CarModel.FOCUS, CarType.COMPACT, rand.nextInt((max - min) + 1) + min));
        compactList.add(new Car(CarBrand.FORD, R.drawable.compact_ford_focus, CarModel.FOCUS, CarType.COMPACT, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.COMPACT, compactList);

        min = 40;
        max = 60;
        ArrayList<Car> midsizeList = new ArrayList<Car>();
        midsizeList.add(new Car(CarBrand.Audi, R.drawable.midsize_audi_a4, CarModel.A4, CarType.MIDSIZE, rand.nextInt((max - min) + 1) + min));
        midsizeList.add(new Car(CarBrand.CHEVROLET, R.drawable.midsize_chevrolet_cruze, CarModel.CRUZE, CarType.MIDSIZE, rand.nextInt((max - min) + 1) + min));
        midsizeList.add(new Car(CarBrand.HYUNDAI, R.drawable.midsize_hyundai_elantra, CarModel.ELANTRA, CarType.MIDSIZE, rand.nextInt((max - min) + 1) + min));
        midsizeList.add(new Car(CarBrand.TOYOTA, R.drawable.midsize_toyota_corolla, CarModel.COROLLA, CarType.MIDSIZE, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.MIDSIZE, midsizeList);

        min = 50;
        max = 65;
        ArrayList<Car> standardList = new ArrayList<Car>();
        standardList.add(new Car(CarBrand.BUICK, R.drawable.standard_buick_verano, CarModel.VERANO, CarType.STANDARD, rand.nextInt((max - min) + 1) + min));
        standardList.add(new Car(CarBrand.VOLKSWAGEN, R.drawable.standard_volkswagen_jetta, CarModel.JETTA, CarType.STANDARD, rand.nextInt((max - min) + 1) + min));
        standardList.add(new Car(CarBrand.HYUNDAI, R.drawable.standard_hyundai_sonata, CarModel.SONATA, CarType.STANDARD, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.STANDARD, standardList);

        min = 55;
        max = 70;
        ArrayList<Car> fullSizeList = new ArrayList<Car>();
        fullSizeList.add(new Car(CarBrand.CHEVROLET, R.drawable.fullsize_chevrolet_malibu, CarModel.MALIBU, CarType.FULLSIZE, rand.nextInt((max - min) + 1) + min));
        fullSizeList.add(new Car(CarBrand.TOYOTA, R.drawable.fullsize_toyota_camry, CarModel.CAMRY, CarType.FULLSIZE, rand.nextInt((max - min) + 1) + min));
        fullSizeList.add(new Car(CarBrand.NISSAN, R.drawable.fullsize_nissan_altima, CarModel.ALTIMA, CarType.FULLSIZE, rand.nextInt((max - min) + 1) + min));
        fullSizeList.add(new Car(CarBrand.FORD, R.drawable.fullsize_ford_fusion, CarModel.FUSION, CarType.FULLSIZE, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.FULLSIZE, fullSizeList);

        min = 80;
        max = 90;
        ArrayList<Car> premiumList = new ArrayList<Car>();
        premiumList.add(new Car(CarBrand.DODGE, R.drawable.premium_dodge_charger, CarModel.CHARGER, CarType.PREMIUM, rand.nextInt((max - min) + 1) + min));
        premiumList.add(new Car(CarBrand.NISSAN, R.drawable.premium_nissan_maxima, CarModel.MAXIMA, CarType.PREMIUM, rand.nextInt((max - min) + 1) + min));
        premiumList.add(new Car(CarBrand.MERCEDESBENZ, R.drawable.premium_mercedesbenz_cla, CarModel.CLA, CarType.PREMIUM, rand.nextInt((max - min) + 1) + min));
        premiumList.add(new Car(CarBrand.FORD, R.drawable.premium_ford_taurus, CarModel.TAURUS, CarType.PREMIUM, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.PREMIUM, premiumList);

        min = 85;
        max = 120;
        ArrayList<Car> luxuryList = new ArrayList<Car>();
        luxuryList.add(new Car(CarBrand.CADILLAC, R.drawable.luxury_cadillac_xts, CarModel.XTS, CarType.LUXURY, rand.nextInt((max - min) + 1) + min));
        luxuryList.add(new Car(CarBrand.MERCEDESBENZ, R.drawable.luxury_suv_mercedesbenz_glc, CarModel.GLC, CarType.LUXURY, rand.nextInt((max - min) + 1) + min));
        luxuryList.add(new Car(CarBrand.BMW, R.drawable.luxury_convertible_bmw4series, CarModel.BMW4SERIES, CarType.LUXURY, rand.nextInt((max - min) + 1) + min));
        luxuryList.add(new Car(CarBrand.CHRYSLER, R.drawable.luxury_chrysler300, CarModel.CHRYSLER300, CarType.LUXURY, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.LUXURY, luxuryList);

        min = 85;
        max = 100;
        ArrayList<Car> convertibleList = new ArrayList<Car>();
        convertibleList.add(new Car(CarBrand.BMW, R.drawable.luxury_convertible_bmw4series, CarModel.BMW4SERIES, CarType.CONVERTIBLE, rand.nextInt((max - min) + 1) + min));
        convertibleList.add(new Car(CarBrand.CHEVROLET, R.drawable.premium_elite_convertible_chevy_camaro, CarModel.CHEVYCAMARO, CarType.CONVERTIBLE, rand.nextInt((max - min) + 1) + min));
        convertibleList.add(new Car(CarBrand.CHRYSLER, R.drawable.standard_convertible_chrysler200, CarModel.CHRYSLER200, CarType.CONVERTIBLE, rand.nextInt((max - min) + 1) + min));
        convertibleList.add(new Car(CarBrand.BMW, R.drawable.luxury_convertible_bmw4series, CarModel.BMW4SERIES, CarType.CONVERTIBLE, rand.nextInt((max - min) + 1) + min));
        convertibleList.add(new Car(CarBrand.FORD, R.drawable.standard_convertible_ford_mustang, CarModel.MUSTANG, CarType.CONVERTIBLE, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.CONVERTIBLE, convertibleList);

        min = 50;
        max = 80;
        ArrayList<Car> suvList = new ArrayList<Car>();
        suvList.add(new Car(CarBrand.MERCEDESBENZ, R.drawable.luxury_suv_mercedesbenz_glc, CarModel.GLC, CarType.SUV, rand.nextInt((max - min) + 1) + min));
        suvList.add(new Car(CarBrand.CHEVROLET, R.drawable.standard_suv_chevrolet_traverse, CarModel.TRAVERSE, CarType.SUV, rand.nextInt((max - min) + 1) + min));
        suvList.add(new Car(CarBrand.FORD, R.drawable.standard_suv_ford_edge, CarModel.EDGE, CarType.SUV, rand.nextInt((max - min) + 1) + min));
        suvList.add(new Car(CarBrand.HYUNDAI, R.drawable.standard_suv_hyundai_santafe, CarModel.SANTAFE, CarType.SUV, rand.nextInt((max - min) + 1) + min));
        carMap.put(CarType.SUV, suvList);
    }

    public static synchronized CarData getInstance(){
        if(instance == null){
            instance = new CarData();
        }
        return instance;
    }

    public HashMap<CarType, ArrayList<Car>> getCarMap() {
        return carMap;
    }
}
