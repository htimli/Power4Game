

import game.*;
import ui.*;



public class Power4Game {

	public static void run(Puissance4 p, Puissance4Builder builder) {
		while(!p.isFinished()) {
			//System.out.println(p);
			p.buildPuissance4(builder);
			System.out.println(((TextBuilder)builder).getResult());			
			System.out.println("Player " + p.getCurrentPlayer() +  " turn");
			p.play(p.getCurrentPlayer().play());
		}		
		System.out.println(p);
	}
	
	public static void main(String argv[]) {
		Puissance4 p = Puissance4Impl.instance();
		
		/*
		BotAbstractFactory factory = new HumanPlayer();
		P4Player p3 = factory.create(p);
		*/
		P4Player p1 = new HumanBot(p);
		//P4Player p2 = new DirectWinBot(new RandomBot(p) ,p);
		P4Player p2 = new HumanBot(p);
		p.init(p1, p2);
		Puissance4Builder builder = new TextBuilder();
		
		run(p,builder);
	}

}
