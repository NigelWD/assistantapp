import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class appTests {

	@Test
	void testConstructor() {
		App a = new App();
		assertEquals("Dummy App", a.getName());
		assertEquals("Dummy object for testing purposes", a.getDescription());
		assertEquals(0.99, a.getPrice());
		
		App b = new App("Instagram", "App for sharing pics with friends", "Facebook",
				"iOS, Android", "instagram.com", "3.06.02", 0.0);
		
		assertEquals("Instagram", b.getName());
		assertEquals("iOS, Android", b.getPlatform());
		assertEquals("Facebook", b.getOrganization());
	}
	
	@Test
	void testString() {
		App a = new App();
		System.out.println(a);
	}
	
	@Test
	void testSet() {
		App a = new App();
		assertEquals("Dummy App", a.getName());
		a.setName("Twitter");
		assertEquals("Twitter", a.getName());
	}

}
