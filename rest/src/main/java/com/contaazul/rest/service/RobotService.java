package com.contaazul.rest.service;


import java.util.logging.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.contaazul.rest.model.Position;
import com.contaazul.rest.model.Robot;

@Path("/{command}")
public class RobotService {
	private final Logger LOGGER = Logger.getLogger(getClass().getName());
	
	@POST
	@Produces("text/html")
	/**
	 * Creates a new {@code Robot} and moves it , returning the 
	 * Position {@code String} representation 
	 * @param command
	 * @return {@code Response}
	 */
	public Response move(@PathParam("command") String command){
		Robot robot = new Robot();
		try {
			Position position = robot.move(command);
			return Response.ok(position.toString(), "text/html").build();
		} catch (Exception e){
			LOGGER.severe(e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
