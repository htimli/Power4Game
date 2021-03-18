import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Power4GameTest {
	
	Puissance4 puissance4 ;
	
	@BeforeEach
	void setUp() throws Exception {
		puissance4 = new Puissance4Impl();
		P4Player p1 = new HumanBot(puissance4);
		P4Player p2 = new DirectWinBot(new RandomBot(puissance4) ,puissance4);
		puissance4.init(p1, p2);
		Power4Game.run(puissance4);
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
