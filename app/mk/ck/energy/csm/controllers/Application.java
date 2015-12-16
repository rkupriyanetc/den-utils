package mk.ck.energy.csm.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.about;
import views.html.feedback;
import views.html.index;
import views.html.officialHome;
import views.html.rates;

public class Application extends Controller {
	
	private static final Logger	LOGGER						= LoggerFactory.getLogger( Application.class );
																								
	public static final String	FLASH_MESSAGE_KEY	= "message";
																								
	public static final String	FLASH_ERROR_KEY		= "error";

	public static Result index() {
		return ok( index.render() );
	}
	
	public static Result about() {
		return ok( about.render() );
	}

	public static Result feedback() {
		return ok( feedback.render() );
	}

	public static Result officialHome() {
		return ok( officialHome.render() );
	}
	
	public static Result rates() {
		return ok( rates.render() );
	}
	
	public static String formatTimestamp( final long t ) {
		return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new Date( t ) );
	}
}
