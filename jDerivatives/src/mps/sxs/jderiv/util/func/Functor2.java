package mps.sxs.jderiv.util.func;

public interface Functor2<Param1, Param2, RetT> {
	public RetT apply(Param1 arg1, Param2 arg2);
}
