package com.maninomula.testing.test444

import org.scalatest.Suite
import com.maninomula.main.classes.Assign.wordCount

class AssignTest extends Suite {
  def wordCountTest() {
    val input = "C:/Users/Mani Nomula/workspace/test444data.txt"
    val output = "C:/Users/Mani Nomula/workspace/test4444.txt"
    wordCount(input, output, 3)
    import scala.io.Source
    val s = Source.fromFile(output).getLines.toString
    println(s)
    assert( s === "(a,8)/n(the,8)/n(is,3)")
  }
}