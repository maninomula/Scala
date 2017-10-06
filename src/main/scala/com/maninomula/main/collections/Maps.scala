package com.maninomula.main.collections

object Maps extends App {

  val romamNeumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV")
  println(romamNeumeral(3))
  import scala.collection.mutable.Map
  val treasureMap = Map[Int, String]()
  treasureMap += (1 -> "Go to Island")
  treasureMap += (2 -> "Find Big X on ground")
  treasureMap += (3 -> "Dig.")
  println(treasureMap(2))

}