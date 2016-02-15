package com.contaazul.rest.model;

import org.junit.Test;

import com.contaazul.rest.model.Direction;
import com.contaazul.rest.model.Position;
import com.contaazul.rest.model.Robot;

import junit.framework.Assert;

public class RobotTest {
	/*
	 * Movimento com rota��es para direita:
        curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
        Sa�da esperada: (2, 0, S)
     */
	@Test
	public void shouldMoveTo2_0_S(){
		Robot robot = new Robot();
		robot.move("MMRMMRMM");
		Position position = robot.getPosition();
		Assert.assertEquals(2, position.getX());
		Assert.assertEquals(0, position.getY());
		Assert.assertEquals(Direction.SOUTH,position.getDirection());
	}
	
	
	/*
		Movimento para esquerda:
        Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
        Sa�da esperada: (0, 2, W)
     */
	@Test
	public void shouldMoveTo0_2_W(){
		Robot robot = new Robot();
		robot.move("MML");
		Position position = robot.getPosition();
		Assert.assertEquals(0, position.getX());
		Assert.assertEquals(2, position.getY());
		Assert.assertEquals(Direction.WEST,position.getDirection());
	}
	
	
	/*
		Comando inv�lido:
	    curl -s --request POST http://localhost:8080/rest/mars/AAA
	    Sa�da esperada: 400 Bad Request
	*/
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowInvalidCommand(){
		new Robot().move("AAA");
	}
	
	/*
		Posi��o inv�lida:
	    curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
	    Sa�da esperada: 400 Bad Request
	 */
	@Test(expected = IllegalStateException.class)
	public void shouldThrowInvalidPosition(){
		new Robot().move("MMMMMMMMMMMMMMMMMMMMMMMM");
	}
	
	
	
}
