package com.maninomula.main.functions

object Closures extends App {
  var more = 1
  val addMore = (x: Int) => x + more
  addMore(10)
  more = 9999
  addMore(10)
  val someNum = List(1, 2, 3, 4, 5, 6, 7)
  var sum = 0
  someNum.foreach(sum += _)
  println(sum)
  def makeIncreaser(more: Int) = (x: Int) => x + more
  val inc1 = makeIncreaser(1)
  val inc9999 = makeIncreaser(9999)
  inc1(10)
  inc9999(10)
  //echo 
  var arr = Array("This is mani")

  def echo(args: String*) = for (arg <- args) println(arg)
  echo(arr: _*)
}