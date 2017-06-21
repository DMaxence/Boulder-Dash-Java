package model;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MapTest {

  private Map map;
  

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    
    map = new Map(10, 12, null);
    map.addDiamondCount();
    map.addDiamondCount();
    map.addDiamondCount();
  }

  @After
  public void tearDown() throws Exception {
  }


  @Test
  public void testDecreaseDiamondCount() {
   int expected = 2;
   this.map.decreaseDiamondCount();
   assertEquals(expected, this.map.getDiamondCount());
  }

  @Test
  public void testAddDiamondCount() {
    int expected = 4;
    this.map.addDiamondCount();
    assertEquals(expected, this.map.getDiamondCount());;
  }

  @Test
  public void testGetDiamondCount() {
    int expected = 3;
    assertNotNull(this.map.getDiamondCount());
    assertEquals(expected, this.map.getDiamondCount());
  }

 
  @Test
  public void testGetWidth() {
    assertNotNull(this.map.getWidth());
    assertTrue(this.map.getWidth() > 0);
    
  }

  @Test
  public void testGetHeight() {
    assertNotNull(this.map.getHeight());
    assertTrue(this.map.getHeight() > 0);
  }

  
}
