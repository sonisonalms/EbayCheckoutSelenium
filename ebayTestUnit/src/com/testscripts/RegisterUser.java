package com.testscripts;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class RegisterUser extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.ebay.com/");
		selenium.start();
	}

	@Test
	public void testRegisterUser() throws Exception {
		selenium.open("/");
		selenium.click("id=registerLink");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=firstname", "test");
		selenium.type("id=lastname", "testlast");
		selenium.type("id=email", "testlast5@dispostable.com");
		selenium.type("id=userid", "testtest5dispose");
		selenium.type("id=PASSWORD", "testing1");
		selenium.type("id=rpass", "testing1");
		selenium.click("id=but_submit");
		selenium.click("id=but_cfrm");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
