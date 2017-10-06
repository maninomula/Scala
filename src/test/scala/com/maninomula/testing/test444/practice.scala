package com.maninomula.testing.test444

object practice extends App {

	var dataFile = "C:/Users/Mani Nomula/Documents/kickstart-scala/data-files/movietweets.csv"
			import scala.io.Source
			var lines = Source.fromFile(dataFile).getLines()
			var words = scala.collection.mutable.Buffer[String]()

			for (line <- lines) {
				var firstSplit = line.split(",")
						for (words1 <- firstSplit) {
							var words2 = words1.split(" ")
									for (words3 <- words2) {
										words += words3
									}
						}
			}

	var wordCounts = scala.collection.mutable.Map[String, Int]()

			for (word <- words.toArray) {
				if (!wordCounts.contains(word)) {
					wordCounts += (word -> 0)
				}

				wordCounts(word) = wordCounts(word) + 1
			}
	println("total positive : " + wordCounts("positive"))
	wordCounts.foreach(println)

}