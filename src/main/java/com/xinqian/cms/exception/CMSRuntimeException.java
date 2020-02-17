package com.xinqian.cms.exception;

public class CMSRuntimeException extends Exception{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 2817764925270337759L;
	
	//提供无参构造
	public CMSRuntimeException() {
		
	}
	
	//提供一个有参数的构造方法，参数可以传入异常信息
	public CMSRuntimeException(String message) {
		super(message); //调用exception的有参数的构造方法
		
	}
}
