package de.dc.spring.fx.ui.jregis.metro.ui.events;

public interface IEventContext<T> {

	String getEventId();
	
	T getInput();
}
