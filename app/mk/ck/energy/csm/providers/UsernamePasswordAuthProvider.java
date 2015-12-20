package mk.ck.energy.csm.providers;

import static play.data.Form.form;

import com.google.inject.Inject;

import mk.ck.energy.csm.model.auth.AuthUser;
import play.Application;
import play.data.Form;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;

public class UsernamePasswordAuthProvider {

	private final Application application;

	protected enum LoginResult {
		USER_UNVERIFIED, USER_LOGGED_IN, NOT_FOUND, WRONG_PASSWORD
	}

	public static class UsernamePassword {

		@Required
		@MinLength( 3 )
		private String	username;

		@Required
		@MinLength( 3 )
		private String	password;

		public String getUsername() {
			return username;
		}

		public void setUsername( final String username ) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword( final String password ) {
			this.password = password;
		}
	}
	
	public static final Form< UsernamePassword > LOGIN_FORM = form( UsernamePassword.class );

	@Inject
	public UsernamePasswordAuthProvider( final Application app ) {
		this.application = app;
	}

	protected LoginResult loginUser( final AuthUser authUser ) {
		return LoginResult.USER_LOGGED_IN;
		/*
		 * try {
		 * final User u =
		 * User.findByUsernamePasswordIdentity(
		 * authUser );
		 * if ( !u.isEmailValidated() )
		 * return LoginResult.USER_UNVERIFIED;
		 * else {
		 * for ( final LinkedAccount acc :
		 * u.getLinkedAccounts() )
		 * if ( getKey().equals( acc.getProvider()
		 * ) )
		 * if ( authUser.checkPassword(
		 * acc.getUserId(), authUser.getPassword()
		 * ) )
		 * // Password was correct
		 * return LoginResult.USER_LOGGED_IN;
		 * else
		 * // if you don't return here,
		 * // you would allow the user to have
		 * // multiple passwords defined
		 * // usually we don't want this
		 * return LoginResult.WRONG_PASSWORD;
		 * return LoginResult.WRONG_PASSWORD;
		 * }
		 * }
		 * catch ( final Exception e ) {
		 * return LoginResult.NOT_FOUND;
		 * }
		 */
	}
}
