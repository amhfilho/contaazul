package com.contaazul.rest.model;

import org.junit.Test;

import com.contaazul.rest.model.Area;
import com.contaazul.rest.model.Direction;
import com.contaazul.rest.model.Position;

import org.junit.Assert;

public class AreaTest {

	@Test
	public void cannotMoveFrom_0_5_N(){
		Area area = new Area(5,5);
		Position position = new Position(0,4,Direction.NORTH);
		Assert.assertFalse(area.canMoveFrom(position));
	}
	
	@Test
	public void cannotMoveFrom_0_5_W(){
		Area area = new Area(5,5);
		Position position = new Position(0,4,Direction.WEST);
		Assert.assertFalse(area.canMoveFrom(position));
	}
	
	@Test
	public void cannotMoveFrom_4_0_E(){
		Area area = new Area(5,5);
		Position position = new Position(4,0,Direction.EAST);
		Assert.assertFalse(area.canMoveFrom(position));
	}
	
	@Test
	public void cannotModeFrom_4_0_S(){
		Area area = new Area(5,5);
		Position position = new Position(4,0,Direction.SOUTH);
		Assert.assertFalse(area.canMoveFrom(position));
	}
	
	@Test
	public void canMoveFrom_0_0_E(){
		Area area = new Area(2,2);
		Position position = new Position(0,0,Direction.EAST);
		Assert.assertTrue(area.canMoveFrom(position));
	}
	
	@Test
	public void cannotMoveAtAll(){
		Area area = new Area(1,1);
		Position position = new Position(0,4,Direction.NORTH);
		Assert.assertFalse(area.canMoveFrom(position));
	}
}
