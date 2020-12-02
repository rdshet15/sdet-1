package activity1;

import java.awt.Point;

abstract class Book {
	String  title;
	
	//abstract method
	abstract void setTitle(String S) ;
	
	//concrete method
	String getTitle() {
		return(title);
		
	}
}
	
	//define abstact method
	class myBook extends Book{
		public void setTitle(String S) {
			title = S;
			
			
		}
		
		
	}
	
public class Activity2_1 {
	
	public static void main(String[] args) {
		String title = "Hour glass";
		Book newNovel = new myBook();
		newNovel.setTitle(title);
		System.out.println("The tittle is  :"+ newNovel.getTitle());
		
	}
	
}

