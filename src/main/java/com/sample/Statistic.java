package com.sample;

import java.util.HashMap;
import java.util.Map;

public class Statistic{
	private Map<StatAbility, Integer> stat;
	
	public Statistic(int life, int atk, int dex, int def, int elu, int speed, int view, int shrewdness, int luck) {
		super();
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.LIFE, life);
		stat.put(StatAbility.ATTACK, atk);
		stat.put(StatAbility.DEXTERITY, dex);
		stat.put(StatAbility.DEFENCE, def);
		stat.put(StatAbility.ELUSION, elu);
		stat.put(StatAbility.SPEED, speed);
		stat.put(StatAbility.VIEW, view);
		stat.put(StatAbility.SHREWDNESS, shrewdness);
		stat.put(StatAbility.LUCK, luck);




	}
	
	public Statistic(Statistic stats) {
		super();
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.LIFE, stats.getStat(StatAbility.LIFE));
		stat.put(StatAbility.ATTACK, stats.getStat(StatAbility.ATTACK));
		stat.put(StatAbility.DEXTERITY, stats.getStat(StatAbility.DEXTERITY));
		stat.put(StatAbility.DEFENCE, stats.getStat(StatAbility.DEFENCE));
		stat.put(StatAbility.ELUSION, stats.getStat(StatAbility.ELUSION));
		stat.put(StatAbility.SPEED, stats.getStat(StatAbility.SPEED));
		stat.put(StatAbility.VIEW, stats.getStat(StatAbility.VIEW));
		stat.put(StatAbility.SHREWDNESS, stats.getStat(StatAbility.SHREWDNESS));
		stat.put(StatAbility.LUCK, stats.getStat(StatAbility.LUCK));




	}

	public int getStat(StatAbility ability) {
		return this.stat.get(ability);
	}
	
	public void setStat(StatAbility ability, int newValue) {
		this.stat.put(ability, newValue);
	}

	@Override
	public String toString() {
		return "Statistic [stat=" + stat + "]";
	}
	
	
	
}

