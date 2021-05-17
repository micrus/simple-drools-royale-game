package com.sample;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	private List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}
	
	public void notifyObservers(UpdateType ut) {
		this.observers.forEach((Observer o) -> {
			o.update(ut);
		});
	}
	
}
