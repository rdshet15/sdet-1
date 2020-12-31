package Groovy

class Activity_1a {
	public static void main(def args) { 
		
		def InputList = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		def strList = InputList.minus([11,2,19,5])
		def intList = InputList.minus(["Mango", "Apple", "Watermelon"])
		
		println(strList)
		print(intList)
		
	}
}