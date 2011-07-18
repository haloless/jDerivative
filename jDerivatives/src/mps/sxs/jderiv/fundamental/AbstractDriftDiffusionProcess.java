package mps.sxs.jderiv.fundamental;

public abstract class AbstractDriftDiffusionProcess implements DriftDiffusionProcess{

	protected double x0;
	
	protected AbstractDriftDiffusionProcess(double x0){
		this.x0 = x0;
	}
	
	/**
	 * 
	 */
	@Override
	public Double expectation(Double t0, Double x0, Double dt) {
		return x0 + drift(t0, x0) * dt;
	}

	/**
	 * 
	 */
	@Override
	public Double variance(Double t0, Double x0, Double dt) {
		double sigma = diffusion(t0, x0);
		return sigma * sigma * dt;
	}

	@Override
	public abstract double drift(double t, double x);

	@Override
	public abstract double diffusion(double t, double x);

	public double getX0() {
		return x0;
	}

	public void setX0(double x0) {
		this.x0 = x0;
	}

}
