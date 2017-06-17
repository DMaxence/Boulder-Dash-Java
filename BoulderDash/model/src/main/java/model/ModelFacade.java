package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.MapDAO;
import model.element.Sprite;
import model.element.mobile.IMobile;
import model.element.mobile.MyCharacter;
import controller.UserOrder;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {
	
	private IMap map;
	
	private IMobile myCharacter;
	
	private ArrayList<IMobile> pawns;

    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     * @throws IOException 
     */
    public ModelFacade(final int mapID) throws SQLException, IOException {
        super();
        Sprite.loadBuffers();
        this.pawns = new ArrayList<IMobile>();
        MapDAO.getMapById(1, this);
        this.setMyCharacter(new MyCharacter(1, 1, this.getMap()));
        //this.pawns.get(0).setMap(this.getMap());
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public IMap getMap(){
        return this.map;
    }
    
    public void setMap(final Map newMap)
    {
    	this.map = newMap;
    }
    
    private void setMyCharacter(final IMobile newChara)
    {
    	this.myCharacter = newChara;
    }
    
	public void addIMobile(final IMobile mobile) {

		pawns.add(mobile);
	}
    
    public void movePawns()
    {
    	for(IMobile pawn : this.getPawns())
    	{
    		switch (pawn.getSprite().getConsoleImage()) {
			//Falling object
    		case 'O':
				if(pawn.canMoveTo(UserOrder.DOWN))
					pawn.moveDown();
				break;

			default:
				break;
			}
    	}
    }

	@Override
	public IMobile getMyCharacter() {
		return this.myCharacter;
	}
	
	@Override
	public ArrayList<IMobile> getPawns()
	{
		return this.pawns;
	}
}
