package mk.ck.energy.csm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

	private static final Logger	LOGGER						= LoggerFactory.getLogger( Application.class );

	public static final String	FLASH_MESSAGE_KEY	= "message";

	public static final String	FLASH_ERROR_KEY		= "error";
																								
	public static Result index() {
		return ok( index.render( "Your new application is ready." ) );
	}
}
