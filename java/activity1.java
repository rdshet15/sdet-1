package activity1;

public class activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car Toyata = new car();
		Toyata.make = 2017;
		Toyata.color = "Blue";
		Toyata.transmission = "Manual";
		
		//using car class methods
		Toyata.displayCharacteristics();
		Toyata.accelarate();
		Toyata.brake();	
		
	}

}


