package com.sample;

import java.util.Arrays;
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
	/*public Statistic(int overallValue) {
		Random gen = new Random();
		double atk = gen.nextInt(50)+20;
		double def = gen.nextInt(50)+20;
		double dex = gen.nextInt(50)+20;
		double elu = gen.nextInt(50)+20;
		double spd = gen.nextInt(30)+10;
		double viw = gen.nextInt(3)+1;
		double shr = gen.nextInt(20)+10;
		double lck = gen.nextInt(20)+10;
		double sum = atk+def+dex+elu+spd+viw+shr+lck;	
		
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.LIFE, overallValue);
		stat.put(StatAbility.ATTACK, (int)Math.ceil(atk*overallValue/sum));
		stat.put(StatAbility.DEXTERITY,(int)Math.ceil(dex*overallValue/sum));
		stat.put(StatAbility.DEFENCE, (int)Math.ceil(def*overallValue/sum));
		stat.put(StatAbility.ELUSION, (int)Math.ceil(elu*overallValue/sum));
		stat.put(StatAbility.SPEED, (int)Math.ceil(spd*overallValue/sum));
		stat.put(StatAbility.VIEW, (int)Math.ceil(viw*overallValue/sum));
		stat.put(StatAbility.SHREWDNESS, (int)Math.ceil(shr*overallValue/sum));
		stat.put(StatAbility.LUCK, (int)Math.ceil(lck*overallValue/sum));
	}*/
	
	public Statistic(int overallValue) {
		Random gen = new Random();
		int viw = gen.nextInt(3)+1;
		overallValue -= viw;

		Integer[] rnd = new Integer[8];
		
		rnd[0]=0;
		rnd[7]=overallValue;
		
		for (int i = 1; i < 7; i++) {
		    rnd[i] = gen.nextInt(overallValue+1);
		}
		
		Arrays.sort(rnd);
		Integer[] statValue = new Integer[7];
		
		for (int i = 0; i < 7; i++) {
		    statValue[i] = rnd[i + 1] - rnd[i];
		}
				
		this.stat = new HashMap<StatAbility, Integer>();
		stat.put(StatAbility.LIFE, overallValue+viw);
		stat.put(StatAbility.ATTACK, statValue[0]);
		stat.put(StatAbility.DEXTERITY,statValue[1]);
		stat.put(StatAbility.DEFENCE, statValue[2]);
		stat.put(StatAbility.ELUSION, statValue[3]);
		stat.put(StatAbility.SPEED, statValue[4]);
		stat.put(StatAbility.VIEW, viw);
		stat.put(StatAbility.SHREWDNESS, statValue[5]);
		stat.put(StatAbility.LUCK, statValue[6]);
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

