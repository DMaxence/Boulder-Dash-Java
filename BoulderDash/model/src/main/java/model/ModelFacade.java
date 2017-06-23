package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import contract.model.IMap;
import contract.model.IModel;
import contract.model.element.Sprite;
import contract.model.element.mobile.IMobile;
import model.dao.MapDAO;
import model.element.mobile.MyCharacter;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 * 
 * @author Paul Combaldieu
 * @version 1.0
 */
public class ModelFacade implements IModel {

	/** The map. */
	private IMap map;

	/** The player's character. */
	private MyCharacter myCharacter;

	/**
	 * Instantiates a new model facade.
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public ModelFacade(final int mapID) throws SQLException, IOException {
		super();
		Sprite.loadBuffers();
		this.setMap(MapDAO.getMapById(mapID));
		this.setMyCharacter(new MyCharacter(1, 1, this.getMap()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IModel#getExampleById(int)
	 */
	@Override
	public IMap getMap() {
		return this.map;
	}

	public void setMap(final Map newMap) {
		this.map = newMap;
	}

	private void setMyCharacter(final MyCharacter newChara) {
		this.myCharacter = newChara;
	}

	/**
	 * Moves pawns (boulders, diamonds, ...).
	 * Their movement is related to their strategy.
	 */
	public void movePawns() {
		ArrayList<IMobile> copyPawns = new ArrayList<>(this.getMap().getPawns());
		
		for (IMobile pawn : copyPawns) {
			pawn.followMyStrategy();
		}

		if (this.getMyCharacter().isCrushed())
			this.getMyCharacter().die();
	}

	@Override
	public MyCharacter getMyCharacter() {
		return this.myCharacter;
	}
}
