package mps.sxs.jderiv.fundamental;



public abstract class Option extends Instrument {

	protected double strike;
	protected double interestRate;
	protected double maturity;
	protected double price;
	protected double volatility;
	protected double dividend;
	protected Type type;
	protected Exercise exercise;
	
	protected OptionPricer pricer;
	
	
	public Option(String isinCode, String discription, 
			double price, double strike, 
			double volatility, double interestRate,	double dividend, double maturity, 
			Type type, Exercise exercise) {
		super(isinCode, discription);
		this.price = price;
		this.strike = strike;
		this.volatility = volatility;
		this.interestRate = interestRate;
		this.dividend = dividend;
		this.maturity = maturity;
		this.type = type;
		this.exercise = exercise;
	}

	
	
	
	
	
	
	public double getStrike() {
		return strike;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public double getMaturity() {
		return maturity;
	}
	public double getPrice() {
		return price;
	}
	public double getVolatility() {
		return volatility;
	}
	public double getDividend() {
		return dividend;
	}
	public Type getType() {
		return type;
	}
	public Exercise getExercise() {
		return exercise;
	}
	public enum Type{
		CALL, PUT,
	}
	public enum Exercise{
		EUROPEAN, AMERICAN, 
	}
	
	@Override
	public abstract double calculate();
	
	protected abstract void setupPricer();
	
	public void setPricer(OptionPricer pricer){
		this.pricer = pricer;
		// TODO
		setupPricer();
		notifyObservers();
	}
	
	@Override
	protected void performCalculation() {
		setupPricer();
		OptionValue value = pricer.pricing();
		this.netPresentValue = value.getValue();
	}
}











