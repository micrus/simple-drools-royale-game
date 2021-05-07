package com.sample;

import java.util.HashMap;
import java.util.Map;

public class Statistic{
	private Map<StatAbility, Integer> stat;
	
	public Statistic(int life, int atk, int speed, int view, int shrewdness) {
		super();
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.ATK, atk);
		stat.put(StatAbility.LIFE, life);
		stat.put(StatAbility.SPEED, speed);
		stat.put(StatAbility.VIEW, view);
		stat.put(StatAbility.SHREWDNESS, shrewdness);



	}
	
	public Statistic(Statistic stats) {
		super();
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.ATK, stats.getStat(StatAbility.ATK));
		stat.put(StatAbility.LIFE, stats.getStat(StatAbility.LIFE));
		stat.put(StatAbility.SPEED, stats.getStat(StatAbility.SPEED));
		stat.put(StatAbility.VIEW, stats.getStat(StatAbility.VIEW));
		stat.put(StatAbility.SHREWDNESS, stats.getStat(StatAbility.SHREWDNESS));



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

