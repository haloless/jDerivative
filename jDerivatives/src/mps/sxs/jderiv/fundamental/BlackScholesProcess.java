package mps.sxs.jderiv.fundamental;

/**
 * dS = (r - 0.5*sigma^2)*dt + sigma*dz
 * @author admin_2
 *
 */
public class BlackScholesProcess extends AbstractDriftDiffusionProcess {

	protected double r;
	protected double sigma;
	
	public BlackScholesProcess(double r, double sigma, double x0) {
		super(x0);
		this.r = r;
		this.sigma = sigma;
	}

	@Override
	public double drift(double t, double x) {
		return r - 0.5 * sigma * sigma;
	}

	@Override
	public double diffusion(double t, double x) {
		return sigma;
	}

}
