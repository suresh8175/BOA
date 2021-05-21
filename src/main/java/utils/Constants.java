package utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Login | BOAhub";
	public static final String HOME_PAGE_URL = "https://uat-portal.boa.co.nz/home";
	public static final String INVALID_TITLE = "Invalid email or password.";
	public static final String FORGOT_PAGE_URL = "https://uat-portal.boa.co.nz/forgotPassword";
	public static final String FORGOT_RESET_PASSWORD_MESSAGE = "Please check your email inbox for a link to complete the reset.";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final int ACCOUNTS_PAGE_SECTIONS_COUNT = 4;

	public static final String ACCOUNT_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	public static final String REGISTER_SHEET_NAME = "Register";
	public static final String LOGIN_SHEET_NAME = "Login";

	public static List<String> getAccSectionsList() {
		List<String> accList = new ArrayList<>();
		accList.add("My Account");
		accList.add("My Orders");
		accList.add("My Affiliate Account");
		accList.add("Newsletter");
		return accList;
	}
	
}
