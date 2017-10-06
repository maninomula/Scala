package com.maninomula.main.functions
import scala.io.Source
object LongLines {
  //def inside def
  def processFile(fileName: String, width: Int) {
    def processLine(line: String) {
      if (line.length > width)
        println(fileName + ": " + line.trim)
    }
    val source = Source.fromFile(fileName)
    for (line <- source.getLines()) {
      processLine(line)
    }
  }
}
object FindLongLines {
  def main(args: Array[String]) {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
    //Function literals and function values
    (x: Int) => x + 1
    var increase = (x: Int) => x + 1
    increase(10)
    increase = (x: Int) => x + 9999
    //trait traversable contains foreach and filter
    val num = List(1, 2, 3, 4)
    num.foreach(println)
    num.filter(_ > 0)
    val add = (_: Int) + (_: Int)
    (x: Int) => x + 1
    var increase = (x: Int) => x + 1
    increase(1)
    increase = (x: Int) => {
      println("mani")
      x + 1
    }
  }
}