package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.MapDAO;
import model.element.Sprite;
import model.element.mobile.IMobile;
import model.element.mobile.MyCharacter;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 * 
 * @author Tejesh Tailor
 * @version 1.0
 */
public class ModelFacade implements IModel {

	private IMap map;

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

	public void movePawns() {
		/**
		 * for (IMobile pawn : this.getMap().get) { switch
		 * (pawn.getSprite().getConsoleImage()) { // Falling object case 'V': if
		 * ((pawn.getPosition().y == this.getMyCharacter().getPosition().y - 1
		 * && pawn.getPosition().x == this.getMyCharacter().getPosition().x) ||
		 * pawn.getPosition().equals(getMyCharacter().getPosition())) {
		 * this.getMyCharacter().collectDiamond(pawn); break; } case 'O': if
		 * (pawn.canMoveTo(UserOrder.DOWN)) { pawn.moveDown(); if
		 * (this.getMyCharacter().isCrushed()) this.getMyCharacter().die(); }
		 * else { for (IMobile pawnVerif : this.getMap().getPawns()) {
		 * 
		 * if (pawn.getPosition().y == pawnVerif.getPosition().y - 1 &&
		 * pawn.getPosition().x == pawnVerif.getPosition().x) { if
		 * (pawn.canMoveTo(UserOrder.LEFT)) { System.out.println("left"); if
		 * (this.getMap().getSquareIsOccupiedXY(pawnVerif.getPosition().x - 1,
		 * pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
		 * pawn.moveLeft(); break; } if (pawn.canMoveTo(UserOrder.RIGHT)) {
		 * System.out.println("right"); if
		 * (this.getMap().getSquareIsOccupiedXY(pawnVerif.getPosition().x + 1,
		 * pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
		 * pawn.moveRight(); break; } } } } } pawn.doNothing(); }
		 * 
		 * break;
		 * 
		 * case 'M':
		 * 
		 * break;
		 * 
		 * default: break; } }
		 */
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
