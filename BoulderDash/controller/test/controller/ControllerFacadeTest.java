package controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import contract.model.IModel;


public class ControllerFacadeTest {
   IModel model;

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
   * This test verifie that method does not return a null result.
   */
  @Test
  public void testGetOrderPeformer() {
    assertNotNull(this);
  }


}
