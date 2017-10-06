package com.maninomula.main.Basics

import java.io.Reader

object ControlStructures extends App {

  val filename = if (!args.isEmpty) args(0) else "default.txt"
  println(filename)

  //    var line = ""
  //    do{
  //      line = readLine()
  //      println("Read:"+line)
  //    }while(line !="")
  def gcd(i: Int, j: Int): Int = if (j == 0) i else gcd(j, i % j)

  var fileHere = (new java.io.File(".")).listFiles()
  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for (
      file <- fileHere if file.getName.endsWith(".scala");
      line <- fileLines(file) if line.trim.matches(pattern)
    ) println(file + ":" + line.trim)
  grep(".*gcd.*")

  var forLineLengths =
    for {
      file <- fileHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")

    } yield trimmed.length()
  //Exception Handing
  import java.io._
  try {
    val f = new FileReader("input.txt")

  } catch {
    case ex: FileNotFoundException => //Handle missing file
    case ex: IOException           => //Handle other I/O error
  } finally {
    // f.close
  }

  val firstArg = if (!args.isEmpty) args(0) else ""
  val friend =
    firstArg match {
      case "salt"  => "pepper"
      case "chips" => "salsa"
      case "eggs"  => "bacon"
      case _       => "huh?"
    }
  println(friend)
  //looping without breakor continue
  var ii = 0
  var foundIt = false
  while (ii < args.length && !foundIt) {
    if (!args(ii).startsWith("-")) {
      if (args(ii).endsWith(".scala"))
        foundIt = true
    }
  }
  //A recursive alternative to looping with vars
  def searchFrom(i: Int): Int = if (i >= args.length) -1
  else if (args(i).startsWith("-")) searchFrom(i + 1)
  else if (args(i).endsWith(".scala")) i
  else searchFrom(i + 1)

  val i = searchFrom(0)

  //variable scoping
  def printMultiTable() {
    var i = 1
    while (i <= 10) {
      var j = 1
      while (j <= 10) {
        val prod = (i * j).toString()
        var k = prod.length()
        while (k < 4) {
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      println()
      i += 1
    }
  }
  printMultiTable()

  //Functional way to create a multiplication table
  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString()
      val padding = " " * (4 - prod.length())
      padding + prod

    }
  def makeRow(row: Int) = makeRowSeq(row).mkString
  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10) yield makeRow(row)
    tableSeq.mkString("\n")
  }
}