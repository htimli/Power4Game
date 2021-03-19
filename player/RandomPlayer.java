package player;
import game.P4Player;
import game.Puissance4;
import game.RandomBot;

class RandomPlayer implements BotAbstractFactory {
	@Override
	public P4Player create(Puissance4 puissance4) {
		return new RandomBot(puissance4);
	}

}