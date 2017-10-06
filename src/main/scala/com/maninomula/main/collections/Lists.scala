package com.maninomula.main.collections

object Lists extends App {

  //Immutable
  var oneTwo = List(1, 2)
  //oneTwo(1)=3
  var threeFour = List(3, 4)
  var oneTwoThreeFour = oneTwo ::: threeFour

  var thrill = "Will" :: "fill" :: "until" :: Nil
  println("Count: " + thrill.count(s => s.length == 4))
  println("drop: " + thrill.drop(2))
  thrill = List("Will", "Fill", "Until")
  println("DropRight: " + thrill.dropRight(2))
  println("exists: " + thrill.exists(s => s == "Until"))
  println("filter: " + thrill.filter(s => s.length == 4))
  println("forall: " + thrill.forall(s => s.endsWith("l")))
  thrill.foreach(print)
  println("\nHead: " + thrill.head + " Tail: " + thrill.tail)
  //println("remove"+thrill.remove(s=>s.length==4))
  println("init: " + thrill.init + "last: " + thrill.last)
  println("length: " + thrill.length)
  println("mkString: " + thrill.mkString(","))
  println("reverse: " + thrill.reverse)
  //println("sort: "+thrill.sort((s,t)=>s.charAt(0).toLower < r.charAt(0).toLower))

}