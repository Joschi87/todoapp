package todoapp.web;

public class BasicHtmlStuff {
	
	public static String htmlHead = "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" + 
			"		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" + 
			"		<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n" + 
			"		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n" + 
			"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
	
	public static String listGroupStart = "<ul class='list-group'>";
	
	public static String navBarForIFrame = "<ul class='nav nav-tabs'>"
										 + "	<li class='nav-item'>"
										 + "		<a href='http://localhost:8080/allToDoAsList'><Button type='button' class='btn btn-primary'>Start Page</button></a>"
										 + "	</li>"
										 + "</ul>";

}
