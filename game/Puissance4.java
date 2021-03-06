package game;

public interface Puissance4 {
	
	public static final int WIDTH  = 7;
	public static final int HEIGHT = 7;
	
	public void init(P4Player p1, P4Player p2);
	public P4Player getPlayer1();
	public P4Player getPlayer2();
	public P4Player getCurrentPlayer();
	public boolean isFinished();
	public void play(int col);
	public String toString();
	public boolean isFree(int col);
	public boolean checkWin(int col, P4Player player);
	
	public P4Player getPlayerInCase(int i , int j);

	public void buildPuissance4( Puissance4Builder builder);
	
}
