package com.maninomula.main.functions

object Fpractice extends App {

  //imperative Programming
  def printArgs(args: Array[String]): Unit = {

    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }

  }

  //functional step-1:remove vars
  def printArgs1(args: Array[String]) = {

    for (arg <- args) {
      println(arg)
    }
  }

  //functional Step-2:remove side effects

  def formatArgs(args: Array[String]) = args.mkString("\n")
  println(printArgs(args))
  println(printArgs1(args))
  println(formatArgs(args))

}