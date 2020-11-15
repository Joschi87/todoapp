package todoapp.web.lib.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToDoCookies {

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
	 
	 public static String getUserCookie(HttpServletRequest request) {
		 String output = "";
		 Cookie[] cookies = request.getCookies();
		 for(Cookie cookie : cookies) {
			 if(cookie.getName().equals("ToDoAppUser"))
				 output = cookie.getValue();
		 }
		 return output;
	 }
	 
	 public static void deleteUserCookie(HttpServletResponse response) {
		 Cookie cookie = new Cookie("ToDoAppUser", null);
		 cookie.setMaxAge(0);
		 cookie.setPath("/");
		 response.addCookie(cookie);
	 }
	 
	 public static boolean findCookie(HttpServletRequest request, String cookieName) {
		 boolean output = true;
		 Cookie[] cookies = request.getCookies();
		 for (Cookie cookie : cookies) {
			 System.out.println(cookie.getName());
			if(cookie.getName().equals(cookieName)) {
				if(cookie.getValue().equals(null)) {
					output = true;
				}else {
					output = false;
				}
			}else{
				output = false;
			}
		}
		 return output;
	 }
	 
	 public static void setKey(String key, HttpServletResponse response) {
		 Cookie cookie = new Cookie("key", key);
		 cookie.setPath("/");
		 response.addCookie(cookie);
	 }
	 
	 public static void deleteKeyCookie(HttpServletResponse response) {
		 Cookie cookie = new Cookie("key", null);
		 cookie.setMaxAge(0);
		 cookie.setPath("/");
		 response.addCookie(cookie);
	 }
}