package com.maninomula.testing.test444

import junit.framework.TestCase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail

import com.maninomula.main.classes.Element.elem;

class ElementTestCase1 extends TestCase{
  def testUniformElement(){
    val ele = elem('x',2,3)
    assertEquals(2, ele.width)
    assertEquals(3, ele.height)
    try{
      elem('x',-3,-5)
      fail()
    }catch{
      case e: IllegalArgumentException =>
    }
  }
}