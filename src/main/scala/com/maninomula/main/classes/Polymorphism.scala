package com.maninomula.main.classes

abstract class Element1 {
  def demo(){
    println("Element's implementation invoked")
  }
}

class ArrayElement1 extends Element1{
  override def demo(){
    println("ArrayElement's implementation invoked")
  }
}
class LineElement1 extends ArrayElement1{
  override def demo(){
    println("LineElement's implementation invoked")
  }
}
class UniformElement1 extends Element1


object Polymorphism extends App{
  def invokeDemo(e:Element1){
    e.demo()
  }
  println(invokeDemo(new ArrayElement1))
  println(invokeDemo(new LineElement1))
  println(invokeDemo(new UniformElement1))
  
}