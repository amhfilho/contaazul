package com.contaazul.rest.model;
/**
 * Represents the area where the Robot moves
 * {@code numberOfXSectors} contains the number of rectangles in the X axis of the area
 * {@code numberOfYSectors} contains the number of rectangles in the Y axis of the area
 * @author Antonio
 *
 */
public class Area {
	
	private int numberOfXSectors;
	private int numberOfYSectors;
	
	public Area(int numberOfXSectors, int numberOfYSectors){
		if(numberOfXSectors < 1 || numberOfYSectors < 1){
			throw new IllegalArgumentException("Area must contains at least 1 sector for each axis");
		}
		this.numberOfXSectors = numberOfXSectors;
		this.numberOfYSectors = numberOfYSectors;
	}

	public int getNumberOfXSectors() {
		return numberOfXSectors;
	}

	public int getNumberOfYSectors() {
		return numberOfYSectors;
	}
	
	/**
	 * Returns {@code true} if the Robot did not reach the boundaries of the area 
	 * based on the X and Y coordinates 
	 * @param position
	 * @return if the Robot can move or not
	 */
	public boolean canMoveFrom(Position position){
		boolean can = true;
		if(position.getDirection().equals(Direction.NORTH) && position.getY() >= numberOfYSectors-1){
			return false;
		}
		if(position.getDirection().equals(Direction.SOUTH) && position.getY()==0){
			return false;
		}
		if(position.getDirection().equals(Direction.EAST) && position.getX() >= numberOfXSectors-1){
			return false;
		}
		if(position.getDirection().equals(Direction.WEST) && position.getX()==0){
			return false;
		}
		return can;
	}

}
