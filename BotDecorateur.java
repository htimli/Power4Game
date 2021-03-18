
public abstract class BotDecorateur implements P4Player {
	private P4Player _deco;
	private Puissance4 _p;
		
	public BotDecorateur(P4Player _deco , Puissance4 p ) {
		this._p = p;
		this._deco = _deco;
	}
	
	@Override
	public int play() {
		return _deco.play();
	}
	

}
