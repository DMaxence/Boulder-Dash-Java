package contract.controller;

/**
 * <h1>The Interface IIinsaneVehiclesController.</h1>
 *
 * @see IOrderPerformer
 * @author Tejesh Tailor
 *
 */
public interface IBoulderDashController {
  

    /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void start() throws InterruptedException;
    

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}
