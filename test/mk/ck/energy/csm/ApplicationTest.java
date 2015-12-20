package mk.ck.energy.csm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.contentAsString;

import org.junit.Test;

import play.twirl.api.Content;

/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more
 * details.
 */
public class ApplicationTest {

	@Test
	public void simpleCheck() {
		final int a = 1 + 1;
		assertEquals( 2, a );
	}

	@Test
	public void renderTemplate() {
		final Content html = views.html.index.render();
		// assertEquals( "text/html", contentType( html ) );
		assertTrue( contentAsString( html ).isEmpty() );
	}
}
