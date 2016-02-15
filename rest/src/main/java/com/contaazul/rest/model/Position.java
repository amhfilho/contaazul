package com.contaazul.rest.model;

/**
 * Represents the coordinates x and y of the Robot
 * @author Antonio
 *
 */
public class Position {
	
	private int x;
	private int y;
	
	/**
	 * Indicates where the Robot is pointing to
	 */
	private Direction direction;
	
	public Position(int x, int y, Direction direction) {
		super();
		if(x < 0 || y < 0){
			throw new IllegalArgumentException("X and Y must be greater than 0");
		}
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	/**
	 * Returns a new {@code Position} moving 1 step ahead 
	 * incrementing x axis or y axis based on the Direction
	 * @return new {@code Position}
	 */
	public Position move(){
		int newX = x;
		int newY = y;
		if(direction.equals(Direction.NORTH)){
			newY = y+1;
		}
		if(direction.equals(Direction.SOUTH)){
			newY = y-1;
		}
		if(direction.equals(Direction.WEST)){
			newX = x-1;
		}
		if(direction.equals(Direction.EAST)){
			newX = x+1;
		}
		return new Position(newX,newY,direction);
	}
	
	/**
	 * Returns a new {@code Position} turning the Robot left (L) ou right (L)
	 * changing the {@code Direction} according on the actual direction 
	 * @param dir 'L' for left turn or 'R' for right turn
	 * @return {@code Position}
	 * @throws {@code IllegalArgumentException} if dir is not 'L' or 'R' 
	 */
	public Position turn(char dir){
		if(dir == 'R' | dir == 'r'){
			if(direction.equals(Direction.NORTH)){
				return pointTo(Direction.EAST);
			}
			if(direction.equals(Direction.SOUTH)){
				return pointTo(Direction.WEST);
			}
			if(direction.equals(Direction.WEST)){
				return pointTo(Direction.NORTH);
			}
			else{
				return pointTo(Direction.SOUTH);
			}
		}
		else if(dir == 'L' | dir == 'l'){
			if(direction.equals(Direction.NORTH)){
				return pointTo(Direction.WEST);
			}
			if(direction.equals(Direction.SOUTH)){
				return pointTo(Direction.EAST);
			}
			if(direction.equals(Direction.WEST)){
				return pointTo(Direction.SOUTH);
			}
			else{
				return pointTo(Direction.NORTH);
			}
		}
		else {
			throw new IllegalArgumentException("Invalid direction to turn");
		}
	}
	
	
	
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + direction + ")";
	}

	public Position pointTo(Direction direction){
		return new Position(x,y,direction);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Direction getDirection() {
		return direction;
	}
	
	

}
