package ElementFactory;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElementFactoryTest {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testCreateDugDirt() {
    assertNotNull(ElementFactory.createDugDirt());
    assertEquals(ElementFactory.createDugDirt().getSprite().getConsoleImage(), ' ');
  }

  @Test
  public void testCreateFilledDirt() {
    assertNotNull(ElementFactory.createFilledDirt());
    assertEquals(ElementFactory.createFilledDirt().getSprite().getConsoleImage(), '.');
  }

  @Test
  public void testCreateWall() {
    assertNotNull(ElementFactory.createWall());
    assertEquals(ElementFactory.createWall().getSprite().getConsoleImage(), '#');
  }

}
