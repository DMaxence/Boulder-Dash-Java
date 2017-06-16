package model.element;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The Sprite Class.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class Sprite {

    /** The image. */
    private Image   image;

    /** The console image. */
    private char    consoleImage;
    
    /** The selected buffer */
    private BufferedImage buffer;
    
    /** The part of buffer to keep */
    private Rectangle bufferPart;

    /** The is image loaded. */
    private boolean imageLoaded;
    
    public static BufferedImage characterTileSet = null;
    public static BufferedImage mapTileSet = null;

    /**
     * Instantiates a new sprite.
     *
     * @param character
     *            the character
     * @param imageName
     *            the image name
     */
    public Sprite(final char character, final BufferedImage imageBuffer, final Rectangle part) {
        this.setConsoleImage(character);
        this.buffer = imageBuffer;
        bufferPart = part;
    }
    
    public static void loadBuffers()
    {
    	try
    	{
    		Sprite.characterTileSet = ImageIO.read(new File("images/characterSet.png"));
    		Sprite.mapTileSet = ImageIO.read(new File("images/mapSet.png"));
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    		System.out.println("Working directory: " + System.getProperty("user.dir"));
    	}	
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public final Image getImage() {
        return this.image;
    }
    
    /**
     * Loads image.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {
    	System.out.println(buffer);
    	System.out.println(this.getConsoleImage());
    	this.setImage(buffer.getSubimage(bufferPart.x, bufferPart.y, bufferPart.width, bufferPart.height));
    	System.out.println("Loading OK");
    }

    /**
     * Gets the console image.
     *
     * @return the consoleImage
     */
    public final char getConsoleImage() {
        return this.consoleImage;
    }

    /**
     * Sets the image.
     *
     * @param image
     *            the new image
     */
    private void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Sets the console image.
     *
     * @param consoleImage
     *            the consoleImage to set
     */
    private void setConsoleImage(final char consoleImage) {
        this.consoleImage = consoleImage;
    }

    /**
     * Checks if is image loaded.
     *
     * @return true, if is image loaded
     */
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    /**
     * Sets the image loaded.
     *
     * @param isImageLoaded
     *            the new image loaded
     */
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }
}