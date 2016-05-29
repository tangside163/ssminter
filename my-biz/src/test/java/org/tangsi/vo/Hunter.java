package org.tangsi.vo;

public class Hunter<T> {

	private T t;

	public T getData() {
		return t;
	}

	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setData(T t) {
		this.t = t;
	}
}
