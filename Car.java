
//* Car implementation*//

package cs1501_p3;


public class Car implements Car_Inter{

    //A unique VIN number (17 character string of numbers and capital letters (but no I (i), O (o), or Q (q) to avoid confusion with numerals 1 and 0)
    //The car's make (e.g., Ford, Toyota, Honda)
    //The car's model (e.g., Fiesta, Camry, Civic)
    //The price to purchase (in whole dollars)
    //The mileage of the car (in whole miles)
    //The color of the car

    String VIN;
    String make;
    String model;
    int price;
    int mileage;
    String color;

    public Car(String newVIN, String newMake, String newModel, int newPrice, int newMileage, String newColor){
        //check newVIN
        VIN = newVIN;
        make = newMake;
        model = newModel;
        price = newPrice;
        mileage = newMileage;
        color = newColor;
    }
    
    public String getVIN(){
        return VIN;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getPrice(){
        return price;
    }

    public int getMileage(){
        return mileage;
    }

    public String getColor(){
         return color;
    }

    public void setPrice(int newPrice){
        price = newPrice;
    }

    public void setMileage(int newMileage){
        mileage = newMileage;
    }

    public void setColor(String newColor){
        color = newColor;
    }


    

}