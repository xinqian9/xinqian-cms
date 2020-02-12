package com.xinqian.cms.domain.enums;

public enum Gender {
	//定义常量
	MAN("0"),
	WOMAN("1");
	
	//封装私有属性
	private String displayName;
	//有参的构造方法
	private Gender(String displayName) {
		this.displayName = displayName;
	}
	//封装get方法
	public String getDisplayName() {
		return displayName;
	}
	
	//提供一个获得常量的方法
	public String getName() {
		return this.name();
	}
	
	//提供一个获得下标的方法
	public int getOrdinal() {
		return this.ordinal();
	}

	
	
	
}
