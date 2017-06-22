package elementfactory;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import element.elementfactory.ElementFactory;

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
  
  /**
   * This test verifie that method testCreateDugDirt does not return a null result,
   * and we verifie that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testCreateDugDirt() {
    assertNotNull(ElementFactory.createDugDirt());
    assertEquals(ElementFactory.createDugDirt().getSprite().getConsoleImage(), ' ');
  }
  
  /**
   * This test verifie that method testCreateFilledDirt does not return a null result,
   * and verifie that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testCreateFilledDirt() {
    assertNotNull(ElementFactory.createFilledDirt());
    assertEquals(ElementFactory.createFilledDirt().getSprite().getConsoleImage(), '.');
  }
  
  /**
   * This test verifie that method testCreateWall does not return a null result,
   * and verifie that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testCreateWall() {
    assertNotNull(ElementFactory.createWall());
    assertEquals(ElementFactory.createWall().getSprite().getConsoleImage(), '#');
  }

}
