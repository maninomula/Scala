package com.maninomula.testing.test444

import org.testng.annotations.Test
import org.testng.Assert.assertEquals
import com.maninomula.main.classes.Element.elem;

class ElementTests {
  @Test def verifyUniformElemet(){
    val ele = elem('x',2,3)
    assertEquals(ele.width,2)
    assertEquals(ele.height,3)
    
  }
  @Test(
      expectedExceptions = 
        Array(classOf[IllegalArgumentException])
      )
      def elemShouldThrowIAE(){
    elem('x',-2,3)
  }
}