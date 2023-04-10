import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest {
	
	MorseCodeTree tree1;
	
	//assertTrue("Successfully threw an UnsupportedOperationException", true);
	// assertEquals("Begin", iterator.next());
	@BeforeEach
	void setUp() throws Exception {
		tree1 = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree1 = null;
	}

	@Test
	void TestLevelOrder() {
		assertEquals("e t i a n m s u r w d k g o h v f l p j b x c y z q ",tree1.levelOrderTraversal());
	}
	
	@Test
	void TestLNR() {
		
		ArrayList<String> treeArr1 = new ArrayList<>(tree1.toArrayList()); 
		assertEquals("[h, s, v, i, f, u, e, l, r, a, p, w, j, b, d, x, n, c, k, y, t, z, g, q, m, o]",treeArr1.toString());
		
		
		ArrayList<String> treeArr2 = new ArrayList<>(); 
		tree1.LNRoutputTraversal(tree1.getRoot(), treeArr2);
		assertEquals(treeArr1, treeArr2);
	}
	
	
	@Test
	void TestFetch() {
		assertEquals("r",tree1.fetch(".-."));
		assertEquals("o",tree1.fetch("---"));
		assertEquals("y",tree1.fetch("-.--"));
	}
	

}
