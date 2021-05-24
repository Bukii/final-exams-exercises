package at.htlle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DVDTest {

	private DVD dvd;

	@Test
	void testConstructor() {
		dvd = new DVD(1, 2.3f, "4", 5, 6);

		assertEquals(1, dvd.getArticleNumber());
		assertEquals(2.3f * 0.19f + 2.3f, dvd.getPrice());
		assertEquals("4", dvd.getName());
		assertEquals(5, dvd.getDuration());
		assertEquals(6, dvd.getCountryCode());
	}

	@Test
	void testGetter() {
		dvd = new DVD(1, 2.3f, "4", 5, 6);

		assertEquals(1, dvd.getArticleNumber());
		assertEquals(2.3f * 0.19f + 2.3f, dvd.getPrice());
		assertEquals("4", dvd.getName());
		assertEquals(5, dvd.getDuration());
		assertEquals(6, dvd.getCountryCode());
		assertEquals(0.19f, dvd.getVat());
	}
	
	@Test
	void testVat() {
		dvd = new DVD(1, 2.3f, "4", 5, 6);
		
		assertEquals(2.3f * 0.19f + 2.3f, dvd.getPrice());
	}

}
