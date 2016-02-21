package com.testscripts;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class SearchUser extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.ebay.com/");
		selenium.start();
	}

	@Test
	public void testSearchUser() throws Exception {
		selenium.setSpeed("1000");
		selenium.open("/");
		selenium.click("link=Sign in");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=userid", "sonaldispose1");
		selenium.type("id=pass", "testing1");
		selenium.click("id=signed_in");
		selenium.click("id=but_sgnBt");
		selenium.setSpeed("3000");
		assertTrue(selenium.isTextPresent("Hi, sonal"));
		selenium.setSpeed("1000");
		selenium.type("id=gh-ac", "macbook");
		selenium.click("id=gh-btn");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=US Only");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Preferences: US Only"));
		selenium.click("link=Clear All");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=New");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("macbook, New"));
		selenium.click("link=Clear");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("results found for macbook"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
