package mk.ck.energy.csm.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import be.objectify.deadbolt.java.actions.SubjectPresent;
import mk.ck.energy.csm.model.auth.UserRole;
import mk.ck.energy.csm.providers.UsernamePasswordAuthProvider;
import mk.ck.energy.csm.providers.UsernamePasswordAuthProvider.UsernamePassword;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.HeaderNames;
import play.mvc.Http.Response;
import play.mvc.Result;
import views.html.about;
import views.html.feedback;
import views.html.index;
import views.html.login;
import views.html.officialHome;
import views.html.rates;

public class Application extends Controller {
	
	private static final Logger	LOGGER						= LoggerFactory.getLogger( Application.class );
																								
	public static final String	FLASH_MESSAGE_KEY	= "message";
																								
	public static final String	FLASH_ERROR_KEY		= "error";

	@SubjectPresent
	public static Result index() {
		return ok( index.render() );
	}
	
	public static Result about() {
		return ok( about.render() );
	}
	
	@Restrict( { @Group( UserRole.INSP_ROLE_NAME ), @Group( UserRole.OPERP_ROLE_NAME ), @Group( UserRole.OPERU_ROLE_NAME ) })
	public static Result feedback() {
		return ok( feedback.render() );
	}

	public static Result officialHome() {
		return ok( officialHome.render() );
	}
	
	public static Result rates() {
		return ok( rates.render() );
	}

	public static Result login() {
		return ok( login.render( UsernamePasswordAuthProvider.LOGIN_FORM ) );
	}
	
	public static Result doLogin() {
		noCache( response() );
		final Form< UsernamePassword > filledForm = UsernamePasswordAuthProvider.LOGIN_FORM.bindFromRequest();
		if ( filledForm.hasErrors() )
			// User did not fill everything properly
			return badRequest( login.render( filledForm ) );
		else
			// Everything was filled
			return Controller.ok( index.render() );// UsernamePasswordAuthProvider.handleLogin(
																							// ctx() );
	}
	
	public static void noCache( final Response response ) {
		// http://stackoverflow.com/questions/49547/making-sure-a-web-page-is-not-cached-across-all-browsers
		response.setHeader( HeaderNames.CACHE_CONTROL, "no-cache, no-store, must-revalidate" ); // HTTP
																																														// 1.1
		response.setHeader( HeaderNames.PRAGMA, "no-cache" ); // HTTP 1.0.
		response.setHeader( HeaderNames.EXPIRES, "0" ); // Proxies.
	}
	
	public static String formatTimestamp( final long t ) {
		return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new Date( t ) );
	}
}
