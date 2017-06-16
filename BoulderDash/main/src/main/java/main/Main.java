package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     * @throws IOException 
     */
    public static void main(final String[] args) throws SQLException, IOException {
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade(1));

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }
}
