package Tests;

public class LoginATest {

	// username min 4 max 14 chars included
	// username should not be empty
	// username should not contain "#"
	// must be unique

	// password shouldn't be empty
	// password min 8 max 14 chars included
	// at least one number
	// at least on upper case letter
	// at least one lower case letter
	// should not contain "#"

	//	Behavior:
	//	When logging in with correct credentials, the login screen disappear, and a logged in screen appears.
	//	When logging in with incorrect credentials (user name or password), an error message is shown.
	//	When clicking a ‘Register’ button, the create new user screen is shown. Here you can insert user name
	// and password twice, according to the above-mentioned rules. The passwords must match. If accept is pressed,
	// the new user is created and the login screen is shown. If cancel is pressed, the text fields are cleared,
	// and the login screen is shown.
	//	When clicking a ‘Change password’ button, you’re taking to the relevant screen. Here you must insert
	// your current username, your current password, and the new password (which must adhere to the rules).
	// If accept is pressed, the user is updated, and the login screen is shown. If cancel is pressed, the screen
	// is cleared for data, and the login screen is shown.
}
