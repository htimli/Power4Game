package ui;

import game.Puissance4Builder;

public class TextBuilder  implements Puissance4Builder {
	StringBuilder str ;

	public void beginPlateau() {
		str.append("***************\n");
	}
	public void endPlateau() {
		str.append("***************\n");
	}
	public void beginCase() {
		str.append("|");
	}
	public void endCase() {
		
	}
	public void putPlayer1() {
		str.append("X");
	}
	public void putPlayer2() {
		str.append("0");
	}
	public void endLine() {
		str.append("\n");
	}
	public void putEmptyCase() {
		str.append(" ");
	}
	@Override
	public void createNewPuissance4Builder() {
		str= new StringBuilder();	
	}
	
	public String getResult() {
		return str.toString();
	}

	

}
