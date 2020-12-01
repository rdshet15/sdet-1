package activity1;

import com.sun.tools.classfile.Synthetic_attribute;
import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

public class car {
	String  color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	//constructor
	car(){
		tyres = 4;
		doors = 5;
	}
		public void displayCharacteristics() { 
			System.out.println("Color of the car " + color);
			System.out.println("make of the car " + make);
			System.out.println("Transamission of the car " + transmission);
			System.out.println("No of tyres " + tyres);
			System.out.println("No of doors " + doors);
		}
		
		public void accelarate() {
			System.out.println("Car is moving forward");
				}
		
		public void brake() {
			System.out.println("Car has stopped");
			
		}
		
	}
	


