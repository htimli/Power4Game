package game;
public class OpponentBot extends BotDecorateur {
	private Puissance4 _p;
	
	public OpponentBot(P4Player deco ,Puissance4 p) {
		super(deco,p);
		_p = p;
	}
	public int play() {
		P4Player _opponent;
		if (_p.getPlayer1() != this)
			_opponent = _p.getPlayer1();
		else
			_opponent = _p.getPlayer2();
		for (int i=0; i < Puissance4.WIDTH; ++i) { 
			if (_p.checkWin(i, _opponent))
				return i;
		}
		return super.play();
	}
}