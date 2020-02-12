package com.xinqian.cms.vo;

import com.xinqian.cms.domain.User;

public class UserVo extends User{
	private String checkpwd;

	public String getCheckpwd() {
		return checkpwd;
	}

	public void setCheckpwd(String checkpwd) {
		this.checkpwd = checkpwd;
	}
	
}
