package de.dc.fx.ui.jregis.metro.ui.eventbus;

public class EventContext<T> implements IEventContext<T> {

	private String eventId;
	private T input;
	
	public EventContext(String eventId, T input) {
		this.eventId = eventId;
		this.input = input;
	}

	@Override
	public T getInput() {
		return input;
	}

	@Override
	public String getEventId() {
		return eventId;
	}

}
