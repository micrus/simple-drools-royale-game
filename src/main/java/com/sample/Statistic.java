package com.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
	
	/*
	 * Randomly generate statistic 
	 * */
	public Statistic(int overallValue) {
		Random gen = new Random();
		int atk = gen.nextInt(50)+1;
		int def = gen.nextInt(50)+1;
		int dex = gen.nextInt(50)+1;
		int elu = gen.nextInt(50)+1;
		int spd = gen.nextInt(30)+1;
		int viw = gen.nextInt(3)+1;
		int shr = gen.nextInt(20)+1;
		int lck = gen.nextInt(20)+1;
		int sum = atk+def+dex+elu+spd+viw+shr+lck;	
		
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.LIFE, overallValue);
		stat.put(StatAbility.ATTACK, (int)Math.round(atk*overallValue/sum));
		stat.put(StatAbility.DEXTERITY,(int)Math.round(dex*overallValue/sum));
		stat.put(StatAbility.DEFENCE, (int)Math.round(def*overallValue/sum));
		stat.put(StatAbility.ELUSION, (int)Math.round(elu*overallValue/sum));
		stat.put(StatAbility.SPEED, (int)Math.round(spd*overallValue/sum));
		stat.put(StatAbility.VIEW, (int)Math.round(viw*overallValue/sum));
		stat.put(StatAbility.SHREWDNESS, (int)Math.round(shr*overallValue/sum));
		stat.put(StatAbility.LUCK, (int)Math.round(lck*overallValue/sum));
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

