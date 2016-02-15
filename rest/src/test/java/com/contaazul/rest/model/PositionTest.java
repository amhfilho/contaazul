package com.contaazul.rest.model;

import org.junit.Test;

import com.contaazul.rest.model.Direction;
import com.contaazul.rest.model.Position;

import junit.framework.Assert;

public class PositionTest {
	
	@Test
	public void moveTo2_2_North(){
		Position position = new Position(0,0,Direction.EAST);
		Position newPosition = position.move().move().turn('L').move().move();
		
		Assert.assertEquals(2, newPosition.getX());
		Assert.assertEquals(2, newPosition.getY());
		Assert.assertEquals(Direction.NORTH, newPosition.getDirection());
	}
	
	@Test
	public void moveTo3_1_East(){
		Position position = new Position(0,0,Direction.EAST);
		Position newPosition = position.move().move().turn('L').move().turn('R').move();
		Assert.assertEquals(3, newPosition.getX());
		Assert.assertEquals(1, newPosition.getY());
		Assert.assertEquals(Direction.EAST, newPosition.getDirection());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowInvalidMove(){
		new Position(0,0,Direction.EAST).move().turn('A');
	}

}
