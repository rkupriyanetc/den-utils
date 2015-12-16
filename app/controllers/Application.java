package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import db.UserRole;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

	private static final Logger	LOGGER						= LoggerFactory.getLogger( Application.class );

	public static final String	FLASH_MESSAGE_KEY	= "message";

	public static final String	FLASH_ERROR_KEY		= "error";
																								
	@Restrict( { @Group( UserRole.OPERP_ROLE_NAME ), @Group( UserRole.OPERU_ROLE_NAME ), @Group( UserRole.INSP_ROLE_NAME ),
			@Group( UserRole.ADMIN_ROLE_NAME ) })
	public Result index() {
		return ok( index.render( "Your new application is ready." ) );
	}
}
