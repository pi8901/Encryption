package test;

import static org.junit.jupiter.api.Assertions.*;
import app.Caesar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class testCaesar 
{
	static Caesar c;

	@BeforeAll
	static void init()
	{
		c = new Caesar();
	}
	
	@Test
	void testENC() 
	{
		init();
		assertEquals(c.enc("ABCXYZ", 3), "DEFABC");
	}
	
	@Test
	void testDEC()
	{
		init();
		assertEquals(c.dec("ABCXYZ", 3), "XYZUVW");
	}

}
