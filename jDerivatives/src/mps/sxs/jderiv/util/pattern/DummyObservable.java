package mps.sxs.jderiv.util.pattern;

import java.util.Observer;

public interface DummyObservable {
	public void addObserver(Observer o);

	public void notifyObservers();
}
