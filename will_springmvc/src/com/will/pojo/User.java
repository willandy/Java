package com.will.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	private String id;
	private String userName;
	private String password;
	private String email;
	
	
	
	public User() {
		super();
	}
	public User(String id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//������֤���󣬿�����֤ҵ��
	@NotEmpty(message="�û�������Ϊ��")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Size(min=4,max=10,message="���볤�ȱ�����4-10֮��")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@NotEmpty(message="����Ϊ��")
	@Email(message="�����ʽ����ȷ")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
