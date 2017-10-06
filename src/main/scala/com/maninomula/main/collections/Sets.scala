package com.maninomula.main.collections

object Sets extends App {
  var jetSet = Set("Boeing", "Airbus")
  //needs to be var for reassigning
  jetSet += "Lear" //jetSet=jetSet+"Lear"
  jetSet("Boeing")
  println("Contains: " + jetSet.contains("Cessa"))

  import scala.collection.mutable.Set
  val movieSet = Set("Hitch", "Poltergeist")
  movieSet.+=("Sherk")
  println(movieSet)

  import scala.collection.immutable.HashSet
  val hashSet = HashSet("Tomatoes", "Chilies")
  println(hashSet + "Coriander")

}