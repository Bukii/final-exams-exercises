package at.htlle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {

	@Test
	void testBookCount() {
		ShoppingCart.generateArticles();
		
		Integer count = 0;
		for (Article art : ShoppingCart.articleList) {
			if (art instanceof Book) {
				count++;
			}
		}
		assertEquals(ShoppingCart.bookCount, count);
	}

}
