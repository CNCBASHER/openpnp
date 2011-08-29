package org.openpnp.spi;

import org.openpnp.Location;
import org.openpnp.Part;


/**
 * A Head is a moving toolholder on a Machine. The head has a current position. A Head
 * is the movable object in a Machine. 
 */
public interface Head {
	/**
	 * Directs the head to move to it's home position and set all it's axes to 0. 
	 */
	void home() throws Exception;
	
	public double getX();
	
	public double getY();
	
	public double getZ();
	
	public double getA();
	
	/**
	 * Move the Head to the given position. Values are in Machine native units. Heads are not
	 * required to make the movement in any particular order.
	 * @param x
	 * @param y
	 * @param z
	 * @param a
	 */
	void moveTo(double x, double y, double z, double a) throws Exception;

	// TODO change all these methods to take doubles instead of Locations to make it clear that
	// the units are in machine units
	
	/**
	 * Queries the Head to determine if it has the ability to pick from the given Feeder
	 * at the given Location and then move the Part to the destination Location.
	 * @param feeder
	 * @param pickLocation
	 * @param placeLocation
	 * @return
	 */
	public boolean canPickAndPlace(Feeder feeder, Location pickLocation, Location placeLocation);
	
	/**
	 * Commands the Head to pick the Part from the Feeder using the given Location. In general,
	 * this operation should move the nozzle to the specified Location and turn on the
	 * vacuum. Before this operation is called the Feeder has already been commanded to feed the
	 * Part.
	 * @param part
	 * @param feeder
	 * @param pickLocation
	 * @throws Exception
	 */
	public void pick(Part part, Feeder feeder, Location pickLocation) throws Exception;
	
	/**
	 * Commands the Head to place the given Part at the specified Location. In general,
	 * this operation should move the nozzle to the specified Location and turn off the
	 * vacuum.
	 * @param part
	 * @param placeLocation
	 * @throws Exception
	 */
	public void place(Part part, Location placeLocation) throws Exception;
}