package dao.model;
public class User {
	private Integer id;//uniquement nécessaire car persistance Objet/Relationnel
	private String login;
	private String pwd;
	private String firstName;
	private String lastName;

	public User(final Integer id, final String firstName, final String lastName, final String login) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return String.format("%s. %s %s (@%s)", id, firstName, lastName, login);
	}
}