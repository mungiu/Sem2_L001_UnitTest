package Tests;

import org.junit.Before;
import org.junit.Test;

import a.*;
import b.*;
import c.*;
import d.*;

import static org.junit.Assert.*;

public class UtilTest extends Object {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void validatePassword() {
//		if(pw == null || pw.equals("")) return "Password cannot be empty";
		assertEquals("Password cannot be empty",a.Util.validatePassword(null,null));
		assertEquals("Password cannot be empty",a.Util.validatePassword("",""));
//		if(!pw.equals(rpw)) return "Passwords do not match";
		assertEquals("Passwords do not match",a.Util.validatePassword("asdasdasd","dsadsadsa"));
//		if(pw.length() < 8) return "Must be at least 8 chars";
		assertEquals("Must be at least 8 chars",a.Util.validatePassword("asd","asd"));
//		if(pw.length() >= 14) return "Must be at most 14 chars";
		assertEquals("Must be at most 14 chars",a.Util.validatePassword("asdasdasdasdasdasdasdasd","asdasdasdasdasdasdasdasd"));
//		if(!pw.matches(".*\\d+.*")) return "Must contain a number";
		assertEquals("Must contain a number",a.Util.validatePassword("asdasdasd","asdasdasd"));
//		if(!pw.matches("(.*[A-Z]).*")) return "Must contain an upper case letter";
		assertEquals("Must contain an upper case letter",a.Util.validatePassword("asdasdasd1","asdasdasd1"));
//		if(pw.contains("#")) return "Cannot contain #";
		assertEquals("Cannot contain #",a.Util.validatePassword("asdasdasd1A#","asdasdasd1A#"));
//		return "OK";
		assertEquals("OK",a.Util.validatePassword("asdasdasd1A","asdasdasd1A"));
	}
}