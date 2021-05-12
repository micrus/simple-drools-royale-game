package test.com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sample.NPC;
import com.sample.Statistic;
import com.sample.Status;
import com.sample.Weapon;

class TestNPC {
	
	private NPC npc;
	private Weapon gun;
	private Statistic balanceState;

	@BeforeEach
	void setUp() {
		
		gun = new Weapon("gun", 12, 7);
		balanceState = new Statistic(150, 20, 10, 9, 7, 8, 6, 8);
		npc = new NPC("npc", 2, 5, gun, balanceState);
	}
	
	@Test
	void testNPCConstructor() {
		
		assertEquals("npc", npc.getSimbol());
		assertEquals(2, npc.getCol());
		assertEquals(5, npc.getRow());
		npc.getWeapon().equals(gun);
		npc.getBaseStat().equals(balanceState);
		npc.getActualStat().equals(balanceState);
		npc.getStatus().equals(Status.NOT_MOVED);
		
	}
	
	// TODO: Eliminare codice hard-coded testNPCToString()
	
	@Test
	void testNPCToString() {
		
		String npcExpectedString = "NPC [baseStat=Statistic [stat={LIFE=150, ATTACK=20, DEXTERITY=10, DEFENCE=9, ELUSION=7, SPEED=8, VIEW=6, SHREWDNESS=8}], "
				+ "actualStat=Statistic [stat={LIFE=150, ATTACK=20, DEXTERITY=10, DEFENCE=9, ELUSION=7, SPEED=8, VIEW=6, SHREWDNESS=8}], status=NOT_MOVED, "
				+ "weapon=Weapon [weaponName=gun, baseDamage=12, modifier=7], simbol=npc, col=2, row=5, removable=1, steppable=0]";
		assertEquals(npcExpectedString, npc.toString());				
	}	

}
