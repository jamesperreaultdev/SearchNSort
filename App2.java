/**
 * A driver for CS1501 Project 3
 * @author    Dr. Farnan
 */
package cs1501_p3;



public class App2 {
	public static void main(String[] args) {
		CarsPQ cpq = new CarsPQ("build/resources/test/cars.txt");
		Car c = new Car("5", "Ford", "Fiesta", 20, 200000, "White");
		cpq.add(c);

	
		


		System.out.println(cpq.get("PUAF85WU5R6L6H1P9").getColor());
		System.out.println(cpq.get("X1U2PEJSC361L10MZ").getColor());
		System.out.println(cpq.get("16Z2DPEHSUK5KCMEH").getColor());
		
	}
}
