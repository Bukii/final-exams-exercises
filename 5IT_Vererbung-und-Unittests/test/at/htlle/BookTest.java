package at.htlle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	private Book book;

	@Test
	void testConstructor() {
		book = new Book(1, 2.3f, "4", "5", 6);

		assertEquals(1, book.getArticleNumber());
		assertEquals(2.3f * 0.07f + 2.3f, book.getPrice());
		assertEquals("4", book.getTitle());
		assertEquals("5", book.getAuthor());
		assertEquals(6, book.getYear());
	}

	@Test
	void testGetter() {
		book = new Book(1, 2.3f, "4", "5", 6);

		assertEquals(1, book.getArticleNumber());
		assertEquals(2.3f * 0.07f + 2.3f, book.getPrice());
		assertEquals("4", book.getTitle());
		assertEquals("5", book.getAuthor());
		assertEquals(6, book.getYear());
		assertEquals(0.07f, book.getVat());
	}
	
	@Test
	void testVat() {
		book = new Book(1, 2.3f, "4", "5", 6);
		
		assertEquals(2.3f * 0.07f + 2.3f, book.getPrice());
	}

}
