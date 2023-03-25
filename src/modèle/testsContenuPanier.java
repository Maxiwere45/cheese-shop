package modèle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testsContenuPanier {
	private ContenuPanier cP;
	private Fromage f;
	private Article a;

	@Before
	public void setUp() throws Exception {
		cP = new ContenuPanier();
		f = new Fromage("Brebis au Bleu");
		a = new Article(f,"500G",10.0F);
	}

	@After
	public void tearDown() throws Exception {
		cP = null;
		f = null;
		a = null;
	}

	@Test
	public void testAddArticleDansPanier() {
		cP.addArticleDansPanier(f,a,1);
		assertEquals(a,cP.getArticle(0));
	}

	@Test
	public void testIsAlreadyInCart() {
		cP.addArticleDansPanier(f,a,1);
		assertTrue(cP.isAlreadyInCart(a));
	}

	@Test
	public void testViderPanier() {
		cP.addArticleDansPanier(f, a, 1);
		cP.viderPanier();
		assertEquals(0,cP.getTaillePanier());
	}

}
