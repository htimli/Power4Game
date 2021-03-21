package game;

import java.util.HashMap;

public class Puissance4Impl implements Puissance4 {
	
	
	private final int PUISS_3 = 3 ;
	private P4Player [][] _tab;
	private boolean _finished;
	private int _freePlaces;
	private P4Player _player, _p1, _p2;
	
	//private static Puissance4Impl _instance = null;
	private static HashMap<Long,Puissance4Impl> _instance = new HashMap<Long,Puissance4Impl>();
	
	
	
	private Puissance4Impl() {}

	public static Puissance4Impl instance() {
		/*
		if(_instance == null)
			_instance = new Puissance4Impl();
		return _instance; 		
		*/
		Thread currentThread = Thread.currentThread();
		long id_thread = currentThread.getId();
		
		if(_instance.get(id_thread) == null)
			_instance.put(id_thread,new Puissance4Impl());
		return _instance.get(id_thread);
	}
	

	public P4Player getPlayer1() {
		return _p1;
	}
	public P4Player getPlayer2() {
		return _p2;
	}
	
	public P4Player getPlayerInCase( int i ,int j){
		return this._tab[i][j];
	}
	
	
	public void init(P4Player p1, P4Player p2) {
		_p1 = p1;
		_p2 = p2;
		_player = _p1;
		_tab = new P4Player[WIDTH][HEIGHT];
		for (int i=0; i < WIDTH; ++i)
			for (int j=0; j < HEIGHT; ++j)
				_tab[i][j] = null;
		_finished = false;
		_freePlaces = WIDTH * HEIGHT;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("***************\n");
		for (int i=WIDTH-1; i >=0; --i) {
			str.append("|");
			for (int j=0; j < HEIGHT; ++j) {
				if (_tab[i][j] == _p1)
					str.append("X");
				if (_tab[i][j] == null)
					str.append(" ");
				if (_tab[i][j] == _p2)
					str.append("O");
				str.append("|");
			}
			str.append("\n");
		}
		str.append("***************\n");
		return str.toString();
	}
	public void buildPuissance4( Puissance4Builder builder) {
				
		builder.createNewPuissance4Builder();
		builder.beginPlateau();
		for (int i=WIDTH-1; i >=0; --i) {
			builder.beginLine();
			builder.beginCase();
			for (int j=0; j < HEIGHT; ++j) {
				if (_tab[i][j] == _p1)
					builder.putPlayer1();
				if (_tab[i][j] == null)
					builder.putEmptyCase();
				if (_tab[i][j] == _p2)
					builder.putPlayer2();
				builder.endCase(); 
				if(j != HEIGHT-1)
					builder.beginCase();
			}
			builder.endLine();
		}
		builder.endPlateau();
		builder.finish();
	}

	public boolean isFinished() {
		return _finished;
	}

	public boolean isFree(int col) {
		if(_freePlaces <= 0) return false;
		if (col <0 || col >= WIDTH) return false;
		int i=0;
		while(i < HEIGHT && _tab[i][col] != null)
			++i;
		if (i >= HEIGHT)
			return false;
		return true;

	}

	private P4Player switchPlayer() {
		if (_player == _p1)
			return _p2;
		else 
			return _p1;
	}

	public void play(int col) {
		if (isFinished()) return;
		--_freePlaces;
		int i=0;
		while(i < HEIGHT && _tab[i][col] != null)
			++i;
		if (i >= HEIGHT) {
			//error
		}
		_tab[i][col] = _player;
		if (testWin(i, col)) {
			System.out.println("player " + _player + " win");
			_finished = true;
			return;
		}
		_player = switchPlayer();
	}
	
	public boolean testVertical (int i, int col, P4Player p){
		int vCount = 1;
		for (int x = i + 1; x < WIDTH && _tab[x][col] == p; ++x) ++vCount;
		for (int x = i - 1; x >=  0   && _tab[x][col] == p; --x) ++vCount;
		return vCount > PUISS_3;
		}
	
	public boolean testHorizontal(int i, int col, P4Player p){
		int hCount = 1;
		for (int x = col + 1; x < WIDTH && _tab[i][x] == p; ++x) ++hCount;
		for (int x = col - 1; x >=  0   && _tab[i][x] == p; --x) ++hCount;
		return hCount > PUISS_3;
		}
	
	public boolean testDiagTopLeft(int i, int col, P4Player p){           //diagonal  \
		int diagCount = 1;
		for (int x = i + 1, y = col + 1; x < WIDTH && y < HEIGHT && _tab[x][y] == p; ++x, ++y) ++diagCount;
		for (int x = i - 1, y = col - 1; x >= 0 && y >= 0 && _tab[x][y] == p; --x, --y) ++diagCount;
		return diagCount > PUISS_3;
		
	}
	
	public boolean testDiagTopRight(int i, int col, P4Player p) {       //diagonal  /
		int diagCount = 1;
		for (int x = i + 1, y = col - 1; x < WIDTH && y >= 0     && _tab[x][y] == p; ++x, --y) ++diagCount;
		for (int x = i - 1, y = col + 1; x >= 0    && y < HEIGHT && _tab[x][y] == p; --x, ++y) ++diagCount;
		return diagCount > PUISS_3;
	}
	
	public boolean testWin(int i, int col) {
		P4Player p = _tab[i][col];
		//System.out.println("res " +l + " " + h + " " + d1 +  " " +d2);
		
		if(testDiagTopRight(i, col, p) || testDiagTopLeft(i, col, p) ||
		 testHorizontal(i, col, p) || testVertical(i, col, p))  return true;
		return false;
		
	}

	public boolean checkWin(int col, P4Player player) {
		if (!isFree(col)) return false;
		int i=0;
		while(i < HEIGHT && _tab[i][col] != null)
			++i;
		_tab[i][col] = player;
		boolean result = testWin(i, col);
		_tab[i][col] = null;
		return result;
	}

	@Override
	public P4Player getCurrentPlayer() {
		return this._player;
	}
}