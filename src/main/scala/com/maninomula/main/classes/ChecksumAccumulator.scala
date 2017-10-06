package com.maninomula.main.classes
import scala.collection.mutable.Map

class ChecksumAccumulator {
  private var sum = 5
  def add(i: Byte) { sum += i }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  ChecksumAccumulator.calculate("Every value is an object")
}
