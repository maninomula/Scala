package com.maninomula.testing.test444

object Demo extends App{
  println("Welcome to Scala")
  val x = 4+7
  println("The value is ="+x)
  val string1: String =
		"This is a string demo"
  val string2: String =
		s"Interpolation ${string1} example"

	println(string2)
	val int1: Int = 30
	val float1: Float = 3.14159f
	println(int1.isValidInt)
	println(float1.isValidInt)
	val mainStr="I want to say hello, so hello my friend"
	println("hello".r.findAllMatchIn(mainStr).length)
	
	val demoSet2: Set[Int] = Set(1, 2, 3, 3)
	val demoSet3: Set[Int] = Set(3, 5, 2)
	//Set operations
	demoSet2.min
	demoSet2.union(demoSet3)
	demoSet2.intersect(demoSet3)
	
	println("Current Directory : " +
			System.getProperty("user.dir"))
			
				//Save to a file
	import java.io._
	var hondaCount = 0
	val writer = new PrintWriter(new File("demo.log" ))
	writer.write(hondaCount)
	writer.close()
	val players :List[String] =
				List("Tom Hanks","Christie Ford","Jim Smith")
	val scores : List[Int] =
				List(40,24,30)
				
	val height = Map("Tom" -> 178 ,
					"Chirstie" -> 208,
					"Jim" -> 190)
	
	//Map : Apply an operator to each member of the collection
	
	scores.map( (i:Int) => i * 2) 
	
	val yieldTest = for (i <- 1 to 5) yield i * 2
	yieldTest.toList
	
		val upPlayers = for  {
		player <- players
		upPlayer = player.toUpperCase
	} yield upPlayer
}