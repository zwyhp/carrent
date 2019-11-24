package com.xx.sys.utils;
/**
 * 封装 layui 数据表格的数据对象
 * @author lenovo
 *
 */
public class DataGridView {
	private Integer code=0;
	private String mag="";
	private Long count;
	private Object data;
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public DataGridView(Long count, Object data) {
		this.count = count;
		this.data = data;
	}
	public DataGridView( Object data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMag() {
		return mag;
	}
	public void setMag(String mag) {
		this.mag = mag;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
