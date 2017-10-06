package com.maninomula.main.Basics

object ScalaHierarchy {
   /* final def ==(that: Any):Boolean
   final def !=(that: Any):Boolean
   def equals(that: Any): Boolean
   def ##:Int
   def hashCode: Int
   def toString: String
   */

println (42.toString())

42 equals 42
42 max 43
 42 min 43
 1 until 5
 1 to 5
 3.abs
 (-3).abs







}
/*object primitives{
 import java.util
  boolean isequal(int x, int y) {
    return x==y;
   
  }
  
  System.out.println(isEqual(421,421));

}*/
object primitives{
  def isEqual(x:Int, y:Int) = x==y
  isEqual(421,421)
  
  def isEqual(x:Any, y:Any) = x==y
  isEqual(421,421)
  
  
  val x= "abcd".substring(2)
   val y= "abcd".substring(2)
   x==y
x eq y
x ne y


}
object nullNothig extends App{
  
  def error(message: String): Nothing =
    throw new RuntimeException(message)
def divide(x:Int,y:Int): Int=
  if(y != 0) x/y
  else error("cant divde")
  
  
}