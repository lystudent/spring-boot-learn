package com.xingheng.ai.BigDataAnalysis.domain;

/**
 * 自定义异常类
 * @author: lym
 * @Date:2019/1/11 16 45
 * @Description:
 */
public class MyExcption extends RuntimeException {

	public MyExcption(String code, String mgs) {
		this.code = code;
		this.mgs = mgs;
	}

	private String code;
	private String mgs;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public String getMgs() {
		return mgs;
	}

	public void setMgs(String mgs) {
		this.mgs = mgs;
	}
}
