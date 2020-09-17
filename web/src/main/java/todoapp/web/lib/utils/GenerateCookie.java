package todoapp.web.lib.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerateCookie {

	 public static void setKeyCooike(String key, HttpServletResponse response) {
		 Cookie cookie = new Cookie("Key", key);
		 cookie.setPath("/");
		 response.addCookie(cookie);
	 }
	 
	 public static String getKeyCookie(HttpServletRequest request) {
		 String output = "";
		 Cookie[] cookies = request.getCookies();
		 for (Cookie cookie : cookies) {
			 if(cookie.getName().equals("Key")) {
				 output += cookie.getValue();
			 }
		 }
		 return output;
	 }
	 
	 public static void setUsernameCookie(String username, HttpServletResponse response) {
		 Cookie cookie = new Cookie("ToDoAppUser", username);
		 cookie.setPath("/");
		 response.addCookie(cookie);
	 }
}