
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> invalidPasswordsArray;
	ArrayList<String> validPasswordsArray;
	String shortPassword = "short";
	String longPassword = "loooooong";
	String noUpper = "lowercase";
	String yesUpper = "Uppercase";
	String noLower = "UPPERCASE";
	String yesLower = "Lowercase";
	String weakPassword = "weeeeak";
	String strongPassword = "veryverystrong";
	String triplesPassword = "111222333444";
	String doublesPassword = "1122334455";
	String noNumPassword = "onetwothree";
	String yesNumPassword = "12345678910";
	String validPassword = "Th1sis@goodpassword";
	String validPassword2 = "Th1salsois@goodpassword";
	

	@Before
	public void setUp() throws Exception {
		String[] containsInvalidPwd = {"BadPasswordOne", "b@dpassword2", "Badpassword3"};
		invalidPasswordsArray = new ArrayList<String>();
		invalidPasswordsArray.addAll(Arrays.asList(containsInvalidPwd));		
		
		String[] allValidPasswords = {"Goodpassword#1", "@notherGoodPassw0rd", "wowGr3atPa$$words"};
		validPasswordsArray = new ArrayList<String>();
		validPasswordsArray.addAll(Arrays.asList(allValidPasswords));	
		
	}

	@After
	public void tearDown() throws Exception {
		invalidPasswordsArray = null;
		validPasswordsArray= null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(longPassword));
		} 
		catch (LengthException e) {
			fail("This test shouldn't have failed!");
		}
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(shortPassword));
		} 
		catch (LengthException e) {
			System.out.println("This test failed as expected!");
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(yesUpper));
		} 
		catch (NoUpperAlphaException e) {
			fail("This test shouldn't have failed!");
		}
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(noUpper));
		} 
		catch (NoUpperAlphaException e) {
			System.out.println("This test failed as expected!");
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(yesLower));
		} 
		catch (NoLowerAlphaException e) {
			fail("This test shouldn't have failed!");
		}
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(noLower));
		} 
		catch (NoLowerAlphaException e) {
			System.out.println("This test failed as expected!");
		}
	}
	/**
	 * Test if the password has between 6-9 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(strongPassword));
		} 
		catch (WeakPasswordException e) {
			fail("This test shouldn't have failed!");
		}
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(weakPassword));
		} 
		catch (WeakPasswordException e) {
			System.out.println("This test failed as expected!");
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence(doublesPassword));
		} 
		catch (InvalidSequenceException e) {
			fail("This test shouldn't have failed!");
		}
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence(triplesPassword));
		} 
		catch (InvalidSequenceException e) {
			System.out.println("This test failed as expected!");
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(yesNumPassword));
		} 
		catch (NoDigitException e) {
			fail("This test shouldn't have failed!");
		}
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(noNumPassword));
		} 
		catch (NoDigitException e) {
			System.out.println("This test failed as expected!");
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
		} 
		catch (Exception e) {
			fail("This test shouldn't have failed!");
		}
		try {
				assertTrue(PasswordCheckerUtility.isValidPassword(validPassword2));
			} 
		catch (Exception e) {
			fail("This test shouldn't have failed!");
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(invalidPasswordsArray);
		assertEquals(results.size(), 3);
		assertEquals(results.get(0), "BadPasswordOne -> The password must contain at least one digit");
		assertEquals(results.get(1), "b@dpassword2 -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(2), "Badpassword3 -> The password must contain at least one special character");
		
		ArrayList<String> results2;
		results2 = PasswordCheckerUtility.getInvalidPasswords(validPasswordsArray);
		assertEquals(results2.size(), 0);
		

	}
	
}
