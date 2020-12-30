package Groovy

class Activity_1b {


	public static void main(def args){
		
		File file = new File("src/input.txt");
		
		def input = 'A quick brown Fox jumped over the lazy Cow \nJohn Jimbo jingeled happily ever after \nTh1$ 1$ v3ry c0nfus1ng'

			file.write(input);
			def lines =file.readLines()
			
			file.eachLine { line ->
				println(line)
				if (line ==~ /^A.*Cow$/) {
				println "Line ends with 'Cow' is : $line"
				}
			}
			file.eachLine { line ->
				if (line==~/^J.*/) {
					println "Line that starts with 'J' is :$line"
					
					 }
			}
			file.eachLine { line ->
				if (line==~/.*\d\d.*/) {
					println "Line that has two adjuscent num :$line"
					
					 }
			}
			
			def match1 = file.getText() =~/\S+er/
			println "String(s) matching '/\\S+er/' are : ${match1.findAll()}"
			def match2 = file.getText() =~ /\S*\d\W/
			println "String(s) matching '/\\S*\\d\\W/' are : ${match2.findAll()}"
			}
 }
