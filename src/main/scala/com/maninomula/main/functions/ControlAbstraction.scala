package com.maninomula.main.functions

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file

}

object FileMatcherUsingFunctionValue {
  private def filesHere = (new java.io.File(".")).listFiles

  def fileMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  def filesEnding(query: String) = fileMatching(query, _.endsWith(_))

  def filesContaining(query: String) = fileMatching(query, _.contains(_))

  def filesRegex(query: String) = fileMatching(query, _.matches(_))

}

object FileMatcherConcise {
  private def filesHere = (new java.io.File(".")).listFiles

  def fileMatching(matcher: (String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
      yield file
  }
  def filesEnding(query: String) = fileMatching(_.endsWith(query))

  def filesContaining(query: String) = fileMatching(_.contains(query))

  def filesRegex(query: String) = fileMatching(_.matches(query))

}

object ControlAbstraction {

  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums) {
      if (num < 0)
        exists = true
    }
    exists
  }

  def containsNeg2(nums: List[Int]): Boolean = nums.exists(x => x < 0)

  containsNeg(List(1, -1, 0))
  containsNeg2(List(1, -1, 0))

  def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums) {
      if (num % 2 == 1)
        exists = true
    }
    exists
  }

  def containsOdd2(nums: List[Int]): Boolean = nums.exists(_ % 2 == 1)
  containsOdd(List(1, -1, 0))
  containsOdd2(List(1, -1, 0))

}

object Currying {
  def plainOldJava(i: Int, j: Int) = i + j
  def curriedSum(i: Int)(j: Int) = i + j
  plainOldJava(2, 3)
  curriedSum(2)(3)
  val twoPlus = curriedSum(2) _
  twoPlus(5)
  val threePlus = curriedSum _
  val c = threePlus(3)
  c(5)

  //which is equal to 
  def first(x: Int) = (y: Int) => x + y
  val second = first(5)
  second(4)
}

//Writing new control structures
object newControlStructures extends App{
  def twice(op:Double=>Double,x:Double)=op(op(x))
  twice(_+1,5)
  import java.io._
  
  //Version 1
  def WithPrintWriter(file:File, op:PrintWriter=>Unit)={
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close
    }
  }
  WithPrintWriter(new File("C:/Users/Mani Nomula/workspace/test444data.txt"), 
      writer=>writer.println(new java.util.Date))

  //{}--only for single parameters
      println{"Hello"}
  //"Hello".substring{2,3}
  "Hello".substring(2,3)
  
  //version-2
  def WithPrintWriter2(file:File)(op:PrintWriter=>Unit)={
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close
    }
  }
  var file = new File("C:/Users/Mani Nomula/workspace/test444data.txt")
  WithPrintWriter2(file){
    writer=>writer.println(new java.util.Date)
    }
}

object ByNameParameters{
  var assertionEnabled = true
  def myAssert(predicate:()=>Boolean){
    if(assertionEnabled && !predicate())
      throw new AssertionError
  }
  myAssert { () => 5>6 }
  //by using by-name parameter
  def myAssert2(predicate: =>Boolean){
    if(assertionEnabled && !predicate)
      throw new AssertionError
  }
  myAssert2(5>6)
  def myAssert3(predicate:Boolean){
    if(assertionEnabled && !predicate)
      throw new AssertionError
  }
  myAssert3(5>6)
  myAssert2(9/0==0)
  myAssert3(8/0==0)
}



