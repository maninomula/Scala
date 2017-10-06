package com.maninomula.main.classes

import Element.elem

object Element {

  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }
  
  private class UniformElement(ch: Char,
                               override val width: Int,
                               override val height: Int) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)

}

abstract class Element {

  def contents: Array[String]

  def height: Int = contents.length
  def width: Int = contents(0).length

  //def width: Int = if (height == 0) 0 else contents(0).length
  //  val height = contents.length
  //  val width = if(height==0) 0 else contents(0).length

  def above(that: Element): Element = {
    //new ArrayElement(this.contents ++ that.contents)
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    //val contents = new Array[String](this.contents.length)
    //    new ArrayElement(    
    //        for(
    //            (line1,line2) <- this.contents zip that.contents
    //      ) yield line1+line2)
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for (
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2)
  }

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      var right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      var bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"
}

object execute {
  //  var ae1 = new ArrayElement(Array("Hello","world"))
  //  ae1.width
  //  val e1:Element = new ArrayElement(Array("Hello","world"))
  //  //val ae:ArrayElement = new LineElement("Hello!")
  // // val e2: Element = ae
  //  val e3:Element = new UniformElement('x',2,3)
  //  Array(1,2,3) zip Array('a','b')
  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizantalBar = elem('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizantalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizantalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }
  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}