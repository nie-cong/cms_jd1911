package com.briup.apps.cms.utils;
/**
 * 
 * @author nc
 *自定义异常类
 */
public class CustomerException extends  RuntimeException{
	private static final long serialVersionUID = 1L;
	//通过父类构建的构造器
	public CustomerException() {
		super();
	}

	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}

	
	
	
}
