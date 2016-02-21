package com.testscripts;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class login extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.ebay.com/");
		selenium.start();
		selenium.windowMaximize();
	}

	@Test
	public void testLogin() throws Exception {
		selenium.setSpeed("1000");
		selenium.open("/");
		selenium.click("link=Sign in");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=userid", "sonaldispose1");
		selenium.type("id=pass", "testing1");
		selenium.click("id=signed_in");
		selenium.click("id=but_sgnBt");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Hi, sonal!"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
