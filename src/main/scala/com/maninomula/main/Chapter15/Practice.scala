package com.maninomula.main.Chapter15

object Practice extends App{
    abstract class Expr
  case class Var(name: String) extends Expr
   case class Number(num: Double) extends Expr
    case class UnOp(operator: String, arg :Expr) extends Expr
     case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
     
     val v = Var("x")
     val op = BinOp("+" , Number(1), v)
     println(v.name)
     println(op.left)
    
 println(op)
  
  //patternMatching
   def simplifyTop(expr: Expr) : Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e  //Double negation
    case BinOp("+", e, Number(0)) => e // adding zero
    case BinOp("*", e, Number(1)) => e // multiplying by zero
    case _ => expr
  }
    
    // contructor pattern
    
    def constructor(expr: Expr)  = expr match {
      case  BinOp("+", e, Number(0)) => println("a deep match")
      case _=>
    }
      
//seq pattern
    
    def sequence(expr: Expr): Unit = expr match {
      case List(0,_,_) => println("found it")
      case _=>
    }
  
// tuple pattern
    
    def tupleDemo(expr : Any) =
      expr match {
      case (a,b,c) =>println("matched " +a+b+c)
      case _=>
    }
    
    
    
    //typed pattern
    def generalSize(x:Any) = x match {
      case s: String => s.length
      case m: Map[_,_] => m.size
      case _=> -1
    }
    
    // variablebinding
    
    def variableBinding( expr: Expr) = expr match {
      case UnOp("abs", e @ UnOp("abs", _)) => e
      case _=>
    }

// pattern guard
    
    def patternGuard(e: Expr) = e match {
      case BinOp("+", x,y) if x == y => BinOp("*", x, Number(2))
      case _=> e
    }

// pattern overlapss
def simplifyAll(expr: Expr): Expr = expr match {
  case UnOp("-" , UnOp("-",e)) =>
    simplifyAll(e)
    case BinOp("+", e, Number(0)) => 
      simplifyAll(e)
    case BinOp("+", e, Number(1)) => 
    simplifyAll(e)
    case UnOp(op,e) =>
      UnOp(op, simplifyAll(e))
    case _=> expr
}
}
object constantPattern {
  
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi"
    case _=> "something else"
  }
describe(5)
describe("hello")
}

object variablePattern {
  import math.{E, Pi}
  E match {
    case Pi => "strange math?Pi = "+ Pi
    case _=> "ok"
      
  }
}

class sealedclass {
   abstract class Expr
  case class Var(name: String) extends Expr
   case class Number(num: Double) extends Expr
    case class UnOp(operator: String, arg :Expr) extends Expr
     case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
     
     def describe(e: Expr): String = e match {
     case Number(_) => "a number"
     case Var(_) => "a variable"
   }

//optionType
   
   val capitals = Map("france" -> "paris", "japan" -> "tokyo")
 capitals get "france"
 capitals get "north"
 
 def show(x: Option[String]) = x match {
     case Some(s) => s
     case None => "?"
   }

   show(capitals get "north")
}