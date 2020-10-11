package com.example.entity;

/**
 * 
 * @author zhukai
 *
 */
public class Person {
	private String name;                       //����
	private String mobilephone;                //�ֻ�
	private String officephone;                //��˾�绰
	private String familyphone;                //��ͥ�绰
	private String group;                      //Ⱥ��
	private String address;                    //סַ

	public Person(){
		this.name=null;
		this.mobilephone=null;
		this.familyphone=null;
		this.officephone=null;
		this.address=null;
	   
	   
	}
	public Person(String name,String mobilephone){
		this.mobilephone=mobilephone;
		this.name=name;
		this.familyphone=null;
		this.officephone=null;
		this.address=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getOfficephone() {
		return officephone;
	}
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}
	public String getFamilyphone() {
		return familyphone;
	}
	public void setFamilyphone(String familyphone) {
		this.familyphone = familyphone;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	   
}
