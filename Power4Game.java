
public class Power4Game {

	public static void run(Puissance4 p) {
		while(!p.end()) {
			System.out.println(p);
			System.out.println("Player " + p.currentPlayer() +  " turn");
			p.play(p.currentPlayer().play());
		}		
		System.out.println(p);
	}
	public static void main(String argv[]) {
		Puissance4 p = Puissance4Impl.instance();
		P4Player p1 = new HumanBot(p);
		P4Player p2 = new DirectWinBot(new RandomBot(p) ,p);
		p.init(p1, p2);
		run(p);
	}

}
