package mps.sxs.jderiv.fundamental;

/**
 * dx = mu(t,x)dt + sigma(t,x)dz
 * @author admin_2
 *
 */
public interface DriftDiffusionProcess extends ProbabilityProcess<Double, Double, Double>{

	/**
	 * mu(t,x)
	 * @param t
	 * @param x
	 * @return
	 */
	public double drift(double t, double x);
	/**
	 * sigma(t,x)
	 * @param t
	 * @param x
	 * @return
	 */
	public double diffusion(double t, double x);
	
}
