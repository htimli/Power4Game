package game;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.TextBuilder;

class Power4GameTest {
	
	Puissance4 puissance4 ;
	
	@BeforeEach
	void setUp() throws Exception {
		puissance4 = Puissance4Impl.instance();
		P4Player p1 = new HumanBot(puissance4);
		P4Player p2 = new DirectWinBot(new RandomBot(puissance4) ,puissance4);
		puissance4.init(p1, p2);
		Puissance4Builder builder = new TextBuilder();
		Power4Game.run(puissance4 , builder);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLaunch() {
		assertNotNull(puissance4);
	}
	
	@Test
	void testMain() {
		//fail("Not yet implemented");
	}
	

}
