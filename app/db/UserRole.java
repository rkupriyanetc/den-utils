package db;

/**
 * @author RVK
 */
public class UserRole {

	public static final String		OPERU_ROLE_NAME	= "OPERU";												// Юридичні
																								
	public static final String		OPERP_ROLE_NAME	= "OPERP";												// Побут
																								
	public static final String		INSP_ROLE_NAME	= "INSP";

	public static final String		ADMIN_ROLE_NAME	= "ADMIN";

	public static final UserRole	OPERU						= new UserRole( OPERU_ROLE_NAME );
																								
	public static final UserRole	OPERP						= new UserRole( OPERP_ROLE_NAME );

	public static final UserRole	INSP						= new UserRole( INSP_ROLE_NAME );
																								
	public static final UserRole	ADMIN						= new UserRole( ADMIN_ROLE_NAME );
																								
	private final String					name;

	private UserRole( final String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static UserRole getInstance( final String roleName ) {
		switch ( roleName ) {
			case OPERU_ROLE_NAME :
				return OPERU;
			case OPERP_ROLE_NAME :
				return OPERP;
			case INSP_ROLE_NAME :
				return INSP;
			case ADMIN_ROLE_NAME :
				return ADMIN;
			default :
				throw new IllegalArgumentException( "Role name is null" );
		}
	}

	@Override
	public boolean equals( final Object o ) {
		if ( o == null )
			return false;
		if ( o instanceof UserRole )
			return ( ( UserRole )o ).getName().equals( this.getName() );
		return false;
	}
}
