package com.maninomula.testing.test444

import org.scalatest.FunSuite
import org.scalatest.Suite
import org.scalatest.junit.JUnit3Suite
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

import com.maninomula.main.classes.Element.elem;

class ElementSuite1 extends Suite {
  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
    assert(ele.width === 3)
    expect(2) {
      ele.width
    }
    intercept[IllegalArgumentException] {
      elem('i', -2, 3)
    }
  }
}

class ElementSuite extends FunSuite {

  test("elem should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
    assert(ele.width === 3)
    expect(2) {
      ele.width
    }
    intercept[IllegalArgumentException] {
      elem('i', -2, 3)
    }
  }
}

class ElementSuite2 extends JUnit3Suite{
  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
    assert(ele.width === 3)
    expect(2) {
      ele.width
    }
    intercept[IllegalArgumentException] {
      elem('i', -2, 3)
    }
  }
}

class ElementSuite3 extends TestNGSuite{
   @Test def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
    assert(ele.width === 3)
    expect(2) {
      ele.width
    }
    intercept[IllegalArgumentException] {
      elem('i', -2, 3)
    }
  }
}