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

    private static boolean buffersLoaded = false;

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
        
        
        if(!buffersLoaded)
        {
        	try
        	{
        		Sprite.characterTileSet = ImageIO.read(new File("images/characterSet.png"));
        		Sprite.mapTileSet = ImageIO.read(new File("images/mapSet.png"));
        		
        		Sprite.buffersLoaded = true;
        	}
        	catch (IOException e)
        	{
        		e.printStackTrace();
        		System.out.println(e.getMessage());
        		System.out.println(System.getProperty("user.dir"));
        		
        		File folder = new File(System.getProperty("user.dir") + "/images");
        		File[] listOfFiles = folder.listFiles();

        		    for (int i = 0; i < listOfFiles.length; i++) {
        		      if (listOfFiles[i].isFile()) {
        		        System.out.println("File " + listOfFiles[i].getName());
        		      } else if (listOfFiles[i].isDirectory()) {
        		        System.out.println("Directory " + listOfFiles[i].getName());
        		      }
        		    }
        	}
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
    	this.setImage(buffer.getSubimage(bufferPart.x, bufferPart.y, bufferPart.width, bufferPart.height));
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