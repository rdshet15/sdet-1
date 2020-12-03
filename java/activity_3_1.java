package activity1;

import java.util.ArrayList;

public class activity_3_1 {

	public static void main(String[] args) {
		
		//declaring array list of strings
		ArrayList<String> myList = new ArrayList<>();

		//adding objects to array list at default index
		
		myList.add("Apple");
		myList.add("Mango");
		myList.add("Orange");
		
		//adding objects at speific index
		myList.add(2, "banana");
		myList.add(4, "Pinapple");
		
		System.out.println("List all the objects");
		for (String S : myList) {
			System.out.println(S);
			
		}
		
		System.out.println("3rd element in the list " + myList.get(2));
		System.out.println("Is chicku in the list " + myList.contains("chicku"));
		System.out.println("size of the array list " + myList.size());
		
		myList.remove("Mango");
		
		System.out.println("New array list is  " + myList.size());
		}
		
	}

