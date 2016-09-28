package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import paket.Enemy;

public class EnemyTest {

	@Test
	public void healthTest() {
		assertEquals("Health", 4, Enemy.getHealth());	
	}

}
