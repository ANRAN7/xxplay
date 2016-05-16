package com.xxplay.core.pojo;

import java.io.Serializable;

/**
 * ѡ���Ԫ��
 * 
 * @file:SelectModal.java
 * @package_name:com.xxplay.pojo.base
 * @Project:xxplay
 *
 * @Author:����
 * @Copyright ����   2016 All Rights Reserved.
 * 
 * @date:2016��4��8��
 */
@SuppressWarnings("serial")
public class SelectModal implements Serializable{
	private String value;
	
	private String name;
	
	public SelectModal(){
	}
	
	public SelectModal(String name,String value){
		this.name = name;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
