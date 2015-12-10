package myserver.api.modules.dto;

public class SingleDto<T> extends BaseDto {

	private static final long serialVersionUID = -2916196920683084917L;
	private T single;

	public T getSingle() {
		return single;
	}

	public void setSingle(T single) {
		this.single = single;
	}

}
