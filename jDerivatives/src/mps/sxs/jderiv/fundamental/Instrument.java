package mps.sxs.jderiv.fundamental;

import java.util.Observable;
import java.util.Observer;

import mps.sxs.jderiv.util.pattern.DummyObservable;

public abstract class Instrument implements DummyObservable, Observer{

	public Instrument(String isinCode, String discription) {
		super();
		this.isinCode = isinCode;
		this.discription = discription;
		this.netPresentValue = 0;
		this.isExpired = false;
		this.isCalculated = false;
	}

	protected String isinCode;
	protected String discription;
	protected double netPresentValue;
	protected boolean isExpired;
	protected boolean isCalculated;
	
	protected Observable ob = new Observable();

	/**
	 * 
	 */
	protected abstract void performCalculation();
	
	public double calculateNetPresentValue(){
		calculate();
		return isExpired ? 0 : netPresentValue;
	}
	public boolean isExpired(){
		calculate();
		return isExpired;
	}
	
	public boolean isCalculated() {
		return isCalculated;
	}

	public double calculate(){
		if(!isCalculated){
			performCalculation();
		}
		isCalculated = true;
		return 0;
	}
	public void recalculate(){
		performCalculation();
		isCalculated = true;
		notifyObservers();
	}
	
	
	
	
	
	public String getIsinCode() {
		return isinCode;
	}

	public String getDiscription() {
		return discription;
	}

	@Override
	public void addObserver(Observer o) {
		ob.addObserver(o);
	}
	@Override
	public void notifyObservers() {
		ob.notifyObservers(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		isCalculated = false;
		notifyObservers();
	}
	
	
	
}
