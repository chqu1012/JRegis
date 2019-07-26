package de.dc.fx.ui.jregis.metro.ui.eventbus;

public interface IEventContext<T> {

	String getEventId();
	
	T getInput();
}
