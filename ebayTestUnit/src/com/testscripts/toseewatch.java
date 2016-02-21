package com.testscripts;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class toseewatch extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.ebay.com/");
		selenium.start();
		selenium.windowMaximize();
	}

	@Test
	public void testToseewatch() throws Exception {
		
		selenium.open("/");
		selenium.click("link=Sign in");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=userid", "sonaldispose1");
		selenium.type("id=pass", "testing1");
		selenium.click("id=signed_in");
		selenium.click("id=but_sgnBt");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=My eBay");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=leftnav_list-99");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//td[@id='itIn'])[2]");
		verifyTrue(selenium.isTextPresent("Add to cart"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
