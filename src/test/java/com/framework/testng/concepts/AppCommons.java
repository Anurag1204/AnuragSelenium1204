package com.framework.testng.concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppCommons extends WebCommons{
	
	@Test(priority = 2,groups = {"Regression"})
	public void TestCase1() {
		// Assert.fail("Test Case 1 Failed");
		System.out.println("Test Case 1 - Home Page Executed Successfully...");
	}
	@Test(priority=3,groups = {"Sanity"},dependsOnMethods = {"TestCase1","TestCase3"},enabled = false)
	public void TestCase2() {
		System.out.println("Test Case 2 - Add Product to Cart Feature Executed Successfully...");
	}	
	@Test(dataProvider = "data",priority = 1,groups = {"Regression","Sanity"})
	public void TestCase3(String username, String password) {
		System.out.println("Test Case 3 - Login Executed Successfully with..."+username+" ,"+password);
	}
}
