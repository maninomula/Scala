package com.maninomula.main.functions

import java.io.PrintStream

object NamedAndTailRecursion extends App {
  def speed(distance:Float, time:Float):Float={
    distance/time
  
  }
  speed(100,10)
  speed(distance= 100,time=10)
  speed(time=10,distance=100)
  //defaultParameters
  def prntTime(out:java.io.PrintStream = Console.out) = 
    out.println("time = "+System.currentTimeMillis())
    def printTime2(out:java.io.PrintStream  = Console.out, divisor:Int = 1) = 
      out.println("time="+System.currentTimeMillis()/divisor)
      
      //Tail Recursion
//      def aprroximate(guess:Double):Double = {
//    if(isGoodEnough(guess)) guess
//    else aprroximate(improve(guess))
//  }
//  def approximateLoop(initialGuess:Double):Double = {
//    var guess = initialGuess
//    while(!isGoodEnough(guess))
//      guess = improve(guess)
//      guess
//    
//  }
      
      def boom(x:Int):Int = if(x==0) throw new Exception("boom!") else boom(x-1)+1
      boom(3)
      def bang(x:Int):Int = if(x==0) throw new Exception("bang!") else bang(x-1)
      bang(5)
      //-g:notailcalls
      def isEven(x:Int):Boolean = if(x==0) true else isOdd(x-1)
      def isOdd(x:Int):Boolean = if(x==0) false else isEven(x-1)
      val funValue = nestedFun _
      def nestedFun(x:Int){
        if(x!=0){ println(x);funValue(x-1)}
      } 

}