package com.sample;

import java.util.HashMap;
import java.util.Map;

public class Statistic implements Cloneable{
	private Map<StatAbility, Integer> stat;
	
	public Statistic(int life, int atk) {
		super();
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.ATK, atk);
		stat.put(StatAbility.LIFE, life);
	}
	
	public Statistic(Statistic stats) {
		super();
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.ATK, stats.getStat(StatAbility.ATK));
		stat.put(StatAbility.LIFE, stats.getStat(StatAbility.LIFE));
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

