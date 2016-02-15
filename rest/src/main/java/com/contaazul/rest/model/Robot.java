package com.contaazul.rest.model;

/**
 * Represents the Robot
 * @author Antonio
 *
 */
public class Robot {
	private Position position;
	private Area area;
	
	/**
	 * Creates a new Robot with the default {@code Area} 5x5
	 */
	public Robot(){
		position = new Position(0,0,Direction.NORTH);
		area = new Area(5,5);
	}
	
	/**
	 * Creates a new Robot with the given {@code Area}
	 * @param {@code Area} the area
	 */
	public Robot(Area area){
		new Robot();
		this.area = area;
	}
	
	public Position getPosition(){
		return this.position;
	}
	
	/**
	 * Moves the Robot parsing the command in String format
	 * Eg: 'MML' moves two steps ahead and turns its Direction 90 degrees Left
	 * @param {@code String} the command
	 * @return the new position of the Robot
	 * @throws {@code IllegalArgumentException} if command is empty
	 * @throws {@code IllegalArgumentException} if Robot reaches the boundaries of the area
	 */
	public Position move(String command){
		if(command==null || "".equals(command)){
			throw new IllegalArgumentException("Command must not be null or empty");
		}
		char[] chars = command.toUpperCase().toCharArray();
		Position backupCopyOfLastPosition = new Position(position.getX(),position.getY(),position.getDirection());
		for(char item:chars){
			switch(item){
			case 'R':
			case 'L':
				position = position.turn(item);
				break;
			case 'M':
				if(area.canMoveFrom(position)){
					position = position.move();
					break;
				} else {
					position = backupCopyOfLastPosition;
					throw new IllegalStateException("Cannot move, it already reached the boundaries of area");
				}		
			default:
				throw new IllegalArgumentException("Invalid command");	
			}
		}
		
		return position;
	}
	

	public Area getArea(){
		return this.area;
	}
		
}
