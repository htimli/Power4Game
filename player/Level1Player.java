package player;
import game.OpponentBot;
import game.P4Player;
import game.Puissance4;
import game.RandomBot;

class Level1Player implements BotAbstractFactory {
	@Override
	public P4Player create(Puissance4 puissance4) {
		return new OpponentBot(new RandomBot(puissance4), puissance4);
	}
	
}