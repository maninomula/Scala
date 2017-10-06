package com.maninomula.testing.Element;

import static org.junit.Assert.*;

import org.junit.Test;
import com.maninomula.main.classes.Element;

public class ElementTest {

	@Test
	public void testWidenWorks() {
		Element e = Element.elem("abcd");
		Element e2 = e.widen(10);
		String str = e2.contents()[0];
		assertNotNull(str);
		assertTrue(str.length()==10);
	}
	
	@Test(expected = AssertionError.class)
	public void testWidenWorKsPositive() {
		Element e = Element.elem("abcd");
		Element e2 = e.widen(10);
		String str = e2.contents()[0];
		assertNotNull(str);
		assertTrue(str.length()==11);
	}
	
	@Test
	public void testHeightWorks() {
		Element e = Element.elem("abcd");
		Element e2 = e.heighten(10);
		int l = e2.contents().length;
		assertNotNull(l);
		assertTrue(l==10);
	}
	
	@Test(expected = AssertionError.class)
	public void testHeightWorksPositive() {
		Element e = Element.elem("abcd");
		Element e2 = e.heighten(10);
		int l = e2.contents().length;
		assertNotNull(l);
		assertTrue(l==11);
	}
	
	

}
