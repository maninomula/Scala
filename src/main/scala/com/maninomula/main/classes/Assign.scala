package com.maninomula.main.classes

import java.io.PrintWriter
import java.io.File
import scala.io.Source

object Assign extends App {
  val input = "C:/Users/Mani Nomula/workspace/test444data.txt"
  val output = "C:/Users/Mani Nomula/workspace/test4444.txt"
  wordCount(input, output, 10)

  def wordCount(input: String, output: String, n: Int):String = {

    val lines = Source.fromFile(input).getLines.flatMap(_.split(" ")).toList
      .groupBy(word => word).mapValues(_.length).toSeq.sortWith(_._2 > _._2)
    lines.take(n).mkString("\n")
  }
  
  def writeToFile()={
        writer(output) {
      writer => writer.println()
    }
  }

  private def writer(output: String)(fun: PrintWriter => Unit) = {
    val writer = new PrintWriter(new File(output))
    try {
      fun(writer)
    } finally {
      writer.close
    }
  }
}