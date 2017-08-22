package cn.supertimor.bean;

public class User {
	
		
	private int id;
	private String user_name;
	private String password;
	private int age;
	
	
	public User(int id) {
		super();
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password="
				+ password + ", age=" + age + "]";
	}
	public User(int id, String user_name, String password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
	}
	public User() {
		super();
	}
	
}
