package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.element.IElement;

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
    private static int    idColumnIndex    = 1;
    
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
     */
    /*public static Map getMapById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlMapById);
        Map map = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                map = new Map(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }*/
    
    public static IElement[][] getMapById(final int id) throws SQLException {
	    final CallableStatement callStatement = prepareCall(sqlMapById);
	    callStatement.setInt(1, id);
	    if (callStatement.execute()) {
	        final ResultSet result = callStatement.getResultSet();
	        if (result.first()) {
	            System.out.print(result.getString(mapColumnIndex));
	            System.exit(0)	;
	        }
	        result.close();
	    }
	    return new IElement[1][1];
	}
}
