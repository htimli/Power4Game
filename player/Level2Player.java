package player;
import game.DirectWinBot;
import game.P4Player;
import game.Puissance4;
import game.RandomBot;

class Level2Player implements BotAbstractFactory {
	@Override
	public P4Player create(Puissance4 puissance4) {
		return new DirectWinBot(new RandomBot(puissance4), puissance4);
	}
	
}