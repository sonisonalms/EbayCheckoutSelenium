package com.testscripts;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;
import java.util.Random;

public class WatchListJava extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.ebay.com/");
		selenium.start();
		selenium.windowMaximize();
	}

	@Test
	public void testWatchListJava() throws Exception {
		
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
		selenium.click("link=My eBay");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=leftnav_list-99");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=createSetLink");
		String listName = "iph"+Math.random(); 
		selenium.type("id=tagNameSet", listName);
		selenium.click("id=btnCreate");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Items in your list"));
		selenium.type("id=gh-ac", "iphone 5");
		selenium.click("id=gh-btn");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=Carrier", "label=AT&T");
		selenium.click("id=e1-15");
		selenium.click("css=label.cbx");
		selenium.click("id=e1-20");
		selenium.click("link=Update Results");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img.img");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Add to Watch list");
		selenium.click("link=My eBay");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Watch list");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Buy it now"));
		selenium.open("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&lgout=1");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
