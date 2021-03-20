package ui;

import game.Puissance4Builder;

public class HTMLBuilder implements Puissance4Builder{
	
	String _str;
	
	public HTMLBuilder() {
		
	}
	
	@Override
	public void createNewPuissance4Builder() {
		_str  =  "<!doctype html>"
				+ "<html>"
				+ "<head>"
				+ "<title>Power4Game</title>"
				+ "</head>"
				+ "<body>";
	}

	@Override
	public void beginPlateau() {
		_str += "<p>***************</p>"
				+"<TABLE BORDER=\"1\">";
	}

	@Override
	public void endPlateau() {
		_str += "</Table>"
				+"<p>***************</p>";
		
	}

	@Override
	public void beginCase() {
		_str += "<td>";
		
	}

	@Override
	public void endCase() {
		_str += "</td>";
		
	}

	@Override
	public void putPlayer1() {
		_str += "x";
		
	}

	@Override
	public void putPlayer2() {
		_str += "o";	
	}

	@Override
	public void putEmptyCase() {
		_str += "&nbsp&nbsp";
		
	}

	@Override
	public void endLine() {
		_str += "</tr>";
		
	}

	@Override
	public void beginLine() {
		_str += "<tr>";		
	}
	
	public String getResult() {
		return _str;
	}

	@Override
	public void finish() {
		_str += "</body></html>";
		
	}

}
