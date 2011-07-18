package mps.sxs.jderiv.fundamental;

public interface ProbabilityProcess<TimeT, StateT, VarianceT> {
	/**
	 * 
	 * @param t0
	 * @param x0
	 * @param dt
	 * @return
	 */
	public StateT expectation(TimeT t0, StateT x0, TimeT dt);
	
	/**
	 * 
	 * @param t0
	 * @param x0
	 * @param dt
	 * @return
	 */
	public VarianceT variance(TimeT t0, StateT x0, TimeT dt);
}
