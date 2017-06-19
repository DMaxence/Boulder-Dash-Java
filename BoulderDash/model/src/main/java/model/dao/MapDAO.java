
package model.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ElementFactory.ElementFactory;
import model.IElement;
import model.Map;
import model.element.mobile.Boulder;
import model.element.mobile.Diamond;
import model.element.mobile.Monster;

/**
 * <h1>The Class MapDAO.</h1>
 *
 * @author Paul Combaldieu paul.combaldieu@viacesi.fr
 * @version 1.0
 */
public abstract class MapDAO extends AbstractDAO {

    /** The sql map by id. */
    private static String sqlMapById   = "{call getMapByID(?)}";

    /** The id column index. */
    //private static int    idColumnIndex    = 1;
    
    /** The width column index. */
    private static int    widthColumnIndex    = 2;
    
    /** The height column index. */
    private static int    heightColumnIndex    = 3;

    /** The map column index. */
    private static int    mapColumnIndex  = 4;

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     * @throws IOException 
     */
    public static Map getMapById(final int id) throws SQLException, IOException {
	    final CallableStatement callStatement = prepareCall(sqlMapById);
	    callStatement.setInt(1, id);
	    int width = 0;
	    int height = 0;
    	Map tempMap = null;
	    
	    if (callStatement.execute()) {
	        final ResultSet result = callStatement.getResultSet();
	        if (result.first()) {
	        	width = result.getInt(widthColumnIndex);
	        	height = result.getInt(heightColumnIndex);
	        	tempMap = new Map(width, height, new IElement[width][height]);
	        	
	        	int currentXToWrite = 0;
	        	int currentYToWrite = 0;
	        	boolean skipNext = false;
	        	
	            for(char c : result.getString(mapColumnIndex).toCharArray())
	            {
	            	if(!skipNext)
	            	{
	            		//Adding map element, if pawn, adding dug dirt
		            	tempMap.setOnTheMapXY(currentXToWrite, currentYToWrite, ElementFactory.getFromFileSymbol(c));
		            	
		            	//Now let's check if the element to insert is an IMobile (boulder, diamond..)
		            	//TODO there's one tempMap to remove here
		            	if(c == 'O')
		            		tempMap.addPawn(new Boulder(currentXToWrite, currentYToWrite, tempMap));
		            	else if (c == 'V')
		            	{
		            		tempMap.addPawn(new Diamond(currentXToWrite, currentYToWrite, tempMap));
		            		tempMap.addDiamondCount();
		            	}
		            	else if (c == 'M') {
		            		
		            		tempMap.addPawn(new Monster(currentXToWrite, currentYToWrite, tempMap));
		            	}
		            	
		            	currentXToWrite++;
	            	}
	            	else
	            	{
	            		skipNext = false;
	            	}

	            	//If we get to the carriage return character
	            	if (currentXToWrite % width == 0 && currentXToWrite != 0)
	            	{
	            		currentXToWrite = 0;
	            		currentYToWrite++;
	            		skipNext = true;
	            	}
	            }
	        }
	        else
	        {
	        	System.out.println("Could not find map");
	        	System.exit(1);
	        }
	        result.close();
	    }
	    return tempMap;
	}
}