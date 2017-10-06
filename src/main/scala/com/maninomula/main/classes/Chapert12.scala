package com.maninomula.main.classes

object Chapert12 {
  trait Philosophical{
    def Philosophize(){
      println("I consume memory")
    }
  }
  class Frog extends Animal with Philosophical with Haslegs{
    override def toString = "green"
    override def Philosophize(){println("It ain't easy being "+toString)}
  }
  class Animal
  trait Haslegs
  
  val frog = new Frog
  println(frog.Philosophize())
  
  val phil:Philosophical = frog
  println(phil)
  
  class Point(val x:Int, val y:Int)
  
  trait Rectangular{
    def topLeft:Point
    def bottomRight:Point
    
    def left = topLeft.x 
    def right = bottomRight.x
    def width = right-left
    
  }
  
  abstract class Component extends Rectangular{
    
  }
  
  class Rectangle(val topLeft:Point, val bottomRight:Point) extends Rectangular{
    
  }
  val rect = new Rectangle(new Point(1,2),new Point(2,4))
  println(rect.left+"   "+rect.right+"   "+rect.width)
  
  
  
  
  
  abstract class IntQueue{
    def get(): Int
    def put(x: Int)
  }

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) {buf += x}
}
val queue = new BasicIntQueue
queue.put(10)

queue.put(20)
queue.get()

queue.get()
trait Doubling extends IntQueue{ 
  abstract override def put(x: Int) { super.put(2*x)}

}
class MyQueue extends BasicIntQueue with Doubling
val queuing = new MyQueue
queuing.put(10)

queuing.get()

val queue1 = new BasicIntQueue with Doubling
queue1.put(10)
queue.get()

trait Incrementing extends IntQueue{
  abstract override def put(x: Int) { super.put(x+1)}
  
}
trait Filtering extends IntQueue{
  abstract override def put(x: Int){
    if (x >= 0) super.put(x)
  }
}
val queue2 = (new BasicIntQueue with Incrementing with Filtering)
queue2.put(-1);queue.put(0);queue.put(1)
queue2.get()
}