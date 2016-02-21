package com.testscripts;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class simplesearch extends SeleneseTestCase{
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.ebay.com/");
		selenium.start();
		selenium.windowMaximize();
	}

	@Test
	public void testSimplesearch() throws Exception {
		selenium.setSpeed("1000");
		selenium.open("/");
		selenium.type("id=gh-ac", "canon slr");
		selenium.click("id=gh-cat");
		selenium.select("id=gh-cat", "label=Cameras & Photo");
		selenium.click("id=gh-btn");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("results found for canon slr"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
