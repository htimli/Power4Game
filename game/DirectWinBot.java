package game;
public class DirectWinBot extends BotDecorateur {
	private Puissance4 _p;
	
	public DirectWinBot(P4Player deco ,Puissance4 p) {
		super(deco,p);
		_p = p;
	}
	public int play() {
		for (int i=0; i < Puissance4.WIDTH; ++i) { 
			if (_p.checkWin(i, this))
				return i;
		}
		return super.play();
	}
}