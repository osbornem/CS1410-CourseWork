package coursework.model;

import coursework.Board;
import coursework.Move;


/**
*
* Moves a player forward one place, unless it is in a corner where it rotates it clockwise.
*
* @author Matthew Osborne
*/

public class ConveyorBelt extends Entity {

	private String direction;

	/**
	 *
	 * Get the direction the conveyor is facing.
	 *
	 * @return direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 *
	 * Sets the direction of the conveyor Belt.
	 *
	 * @param direction The direction the conveyor is facing
	 */
	public ConveyorBelt(String direction) {
		this.direction = direction;
	}

	/************************************************************************************/

	/**
	 *
	 * Moves a robot forward in the direction the conveyor is facing
	 *
	 * <p>
	 * If the conveyor belt is in a corner then it rotates the robot clockwise
	 * </p>
	 * @param r Robot
	 */
	public void moveRobot(Robot r) {
		String saveDirection = r.getDirection();
		if (!(Board.checkOutsideBoardForward(r.getRow(), r.getCol(), direction))) {
			if (Board.checkAdjacentSpaceForward(r.getRow(), r.getCol(), direction) == null) {
				r.setDirection(direction);
				Move.forward(r);
				r.setDirection(saveDirection);
			}
		} else {
			Move.right(r);
		}

	}

}
