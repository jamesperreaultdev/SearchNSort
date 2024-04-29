/**
 * CarsPQ for CS1501 Project 3
 * @author    Dr. Farnan
 */
package cs1501_p3;


import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;


public class CarsPQ {

    DLB dlbMinMileage = new DLB();
    DLB dlbMinPrice = new DLB();

    DLB dlbMinMakeModel = new DLB();
    
    MinMileagePQ MMHeap = new MinMileagePQ();
    MinPricePQ MPHeap = new MinPricePQ();

   CarsPQ(String filename){



    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      String str = myReader.nextLine();
      str = myReader.nextLine();
      while (myReader.hasNextLine()) {
        String[] carSplit = str.split(":");
      
        Car newCar = new Car(carSplit[0],carSplit[1],carSplit[2],Integer.parseInt(carSplit[3]),Integer.parseInt(carSplit[4]),carSplit[5]);
     
        add(newCar);
        str = myReader.nextLine();
        
      }
      String[] carSplit = str.split(":");
    
      Car newCar = new Car(carSplit[0],carSplit[1],carSplit[2],Integer.parseInt(carSplit[3]),Integer.parseInt(carSplit[4]),carSplit[5]);
     
      add(newCar);
      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
   
       
    
    }
   
    
    public void add(Car c) throws IllegalStateException{

        if((dlbMinMileage.contains(c.getVIN()) != 0) || (dlbMinPrice.contains(c.getVIN()) != 0)){
            throw new IllegalStateException("Already present.");
        }
        String stringBuilt = c.getMake() + c.getModel();
        dlbMinMakeModel.addHeap(stringBuilt,c);

        MMHeap.getDLB(dlbMinMileage);
       
        MMHeap.insert(c);

        MPHeap.getDLB(dlbMinPrice);
        MPHeap.insert(c);




    }

    public Car get(String vin) throws NoSuchElementException{
        int heapIndex = dlbMinMileage.contains(vin);
      
        if(heapIndex == 0){
            throw new NoSuchElementException();
        }

        MMHeap.getDLB(dlbMinMileage);
        return MMHeap.pq[heapIndex];

    }

    public void updatePrice(String vin, int newPrice) throws NoSuchElementException{

        int priceIndex = dlbMinPrice.contains(vin);

        if(priceIndex == 0){
            throw new NoSuchElementException("No car with VIN.");
        }

       

         MPHeap.getDLB(dlbMinPrice);
         MPHeap.update(priceIndex,newPrice);
    }

    public void updateMileage(String vin, int newMileage) throws NoSuchElementException{
        int mileageIndex = dlbMinMileage.contains(vin);

        if(mileageIndex == 0){
            throw new NoSuchElementException("No car with VIN.");
        }
        

        MMHeap.getDLB(dlbMinMileage);
        MMHeap.update(mileageIndex,newMileage);
    }

  
    public void updateColor(String vin, String newColor) throws NoSuchElementException{
        int colorMileageIndex = dlbMinMileage.contains(vin);

        if(colorMileageIndex == 0){
            throw new NoSuchElementException("No car with VIN.");
        }

        MMHeap.getDLB(dlbMinMileage);
        MMHeap.pq[colorMileageIndex].setColor(newColor);

        int colorPriceIndex = dlbMinPrice.contains(vin);

        if(colorPriceIndex == 0){
            throw new NoSuchElementException("No car with VIN.");
        }

        MPHeap.getDLB(dlbMinPrice);
        MPHeap.pq[colorPriceIndex].setColor(newColor);


    }

    public void remove(String vin) throws NoSuchElementException{
        
        int heapIndex = dlbMinMileage.contains(vin);
        int heapIndex2 = dlbMinPrice.contains(vin);

   
        if (heapIndex == 0){
            throw new NoSuchElementException("No such car.");
        }

        MMHeap.getDLB(dlbMinMileage);
        MMHeap.remove(heapIndex);

        MPHeap.getDLB(dlbMinPrice);
        MPHeap.remove(heapIndex2);
    }

    public Car getLowPrice(){
        if(MPHeap.size() == 0){
            return null;
        }
       return MPHeap.min();

    }

    public Car getLowPrice(String make, String model){

        String stringBuilder = make + model;
        Car minCar = dlbMinMakeModel.getNode(stringBuilder).pricePQ.min();

        DLBNode Node = dlbMinPrice.getNode(minCar.getVIN());

        
        while(minCar != null){
            if(Node == null){
                if(dlbMinMakeModel.getNode(stringBuilder).pricePQ.isEmpty()){
                    return null;

                }
                dlbMinMakeModel.getNode(stringBuilder).pricePQ.delMin();
                minCar = dlbMinMakeModel.getNode(stringBuilder).pricePQ.min();
                Node = dlbMinPrice.getNode(minCar.getVIN());
            }
            else{
                return minCar;
            }
           
        }

        return null;
    }

    public Car getLowMileage(){
        if(MMHeap.size() == 0){
            return null;
        }
       return MMHeap.min();
    }

    public Car getLowMileage(String make, String model){
        String stringBuilder = make + model;
        Car minCar = dlbMinMakeModel.getNode(stringBuilder).mileagePQ.min();

        DLBNode Node = dlbMinMileage.getNode(minCar.getVIN());

        
        while(minCar != null){
            if(Node == null){
                if(dlbMinMakeModel.getNode(stringBuilder).mileagePQ.isEmpty()){
                    return null;

                }
                dlbMinMakeModel.getNode(stringBuilder).mileagePQ.delMin();
                minCar = dlbMinMakeModel.getNode(stringBuilder).mileagePQ.min();
                Node = dlbMinPrice.getNode(minCar.getVIN());
            }
            else{
                return minCar;
            }
           
        }

        return null;

    }
}