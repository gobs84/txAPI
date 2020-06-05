package services;

@SuppressWarnings("serial")
public class ServiceException extends Exception {
	
	public int code;
	
	public ServiceException(int code, String msg)
	{
		super(msg);
		this.code = code;
	}

	public ServiceException(int code, String msg, Throwable throwable)
	{
		super(msg,throwable);
		this.code = code;
	}
}
