package mk.ck.energy.csm.model.auth;

import org.mindrot.jbcrypt.BCrypt;

public class AuthUser {
	
	final static long			SESSION_TIMEOUT	= 24 * 14 * 3600;
																				
	private final long		expiration;
												
	private final String	username;
												
	private final String	password;
												
	public AuthUser( final String clearPassword, final String username ) {
		this.password = clearPassword;
		this.username = username;
		expiration = System.currentTimeMillis() + 1000 * SESSION_TIMEOUT;
	}
	
	public String getHashedPassword() {
		return createPassword( this.password );
	}

	protected String createPassword( final String clearString ) {
		return BCrypt.hashpw( clearString, BCrypt.gensalt() );
	}
	
	/**
	 * You *SHOULD* provide your own implementation of this which implements your
	 * own security.
	 */
	public boolean checkPassword( final String hashed, final String candidate ) {
		if ( hashed == null || candidate == null )
			return false;
		return BCrypt.checkpw( candidate, hashed );
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public long expires() {
		return expiration;
	}
}
