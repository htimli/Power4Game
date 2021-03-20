package player;
import game.HumanBot;
import game.P4Player;
import game.Puissance4;

class HumanPlayer implements BotAbstractFactory {
	@Override
	public P4Player createPlayer(Puissance4 puissance4) {
		return new HumanBot(puissance4);
	}

	
	
}