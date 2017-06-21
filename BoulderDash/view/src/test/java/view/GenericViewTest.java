package view;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenericViewTest {

	Rectangle closeView;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		closeView = new Rectangle(1, 2, 3, 4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCloseView() {
		assertTrue(this.closeView.getX() > 0 && this.closeView.getY() > 0);
	}

}
