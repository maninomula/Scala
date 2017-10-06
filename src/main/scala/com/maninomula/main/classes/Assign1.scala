package com.maninomula.main.classes

object Assign1 extends App {

  val input = "C:/Users/Mani Nomula/workspace/test444data.txt"
  val output = "C:/Users/Mani Nomula/workspace/test4444.txt"
  wordCount(input, output, 10)
  

  def wordCount(input: String, output: String, n: Int) = {
    import scala.io.Source
    import java.io.PrintWriter
    import java.io.File
    val lines = Source.fromFile(input).getLines.flatMap(_.split(" ")).toList.
      groupBy(word => word).mapValues(_.length).toSeq.sortWith(_._2 > _._2)
    val writer = new PrintWriter(new File(output))
    writer.println(lines.take(n).mkString("\n"))
    writer.close
  }
  
  
  
}