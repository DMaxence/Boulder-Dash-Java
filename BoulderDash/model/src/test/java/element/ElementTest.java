package element;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.element.Permeability;
import contract.model.element.Sprite;

public class ElementTest {
  private Sprite sprite;
  private Permeability permeability = Permeability.PENETRABLE;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }
  
  /**
   * We create a non-null size new sprite.
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    sprite = new Sprite('T', Sprite.characterTileSet, new Rectangle(1,93,27,92));
  }

  @After
  public void tearDown() throws Exception {
  }

  /**
   * This test verifie that method testGetsprite does not return a null result.
   */
  @Test
  public void testGetSprite() {
    assertNotNull(this.sprite);
    assertNotNull(this.sprite.getConsoleImage());
    
  }
  /**
   * This test verifie that method testGetPermeability does not return a null result.
   */
  @Test
  public void testGetPermeability() {
    assertNotNull(this.permeability);
  }

  @Test
  public void testGetImage() {
    /**
     * As we don't load the buffer, we don't have image to load
     * That why we have a null result
     */
    assertNull(this.sprite.getImage());
  }

}
