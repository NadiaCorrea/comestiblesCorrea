package com.jacaranda.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {
	private int id; // es asignado por la base de datos 
	private String userName;
	private String password;
	private String name;
	private String lastname;
	private LocalDate dob;
	private char sex;
	private boolean admin;
	
	
	public User() {
		super();
		
	}


	public User(String userName, String password, String name, String lastname, LocalDate dob, char sex,
			boolean admin) throws UserException {
		super();
		setUserName(userName);
		setPassword(password);
		setName(name);
		setLastname(lastname);
		setDob(dob);
		setSex(sex);
		setAdmin(admin);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}

	/**
	 * método para asignar el nombre de usuario 
	 * @param userName nombre de usuario 
	 * Lanza una UserException si el parametro que recibe es nulo, tiene más de 20 caracteres o son solo espacios en blanco 
	 */
	public void setUserName(String userName) throws UserException {
		if(userName == null || userName.length() > 20 || userName.isBlank()) {
			throw new UserException("El nombre de usuario no puede estar vacío o tener más de 20 caracteres.");
		} else {
			this.userName = userName;
		}
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) throws UserException {
		if(name == null || name.isBlank()) {
			throw new UserException("El nombre no puede estar vacío.");
		} else {
			this.name = name;
		}
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) throws UserException {
		if(lastname == null || lastname.isBlank()) {
			throw new UserException("El apellido no puede estar vacío.");
		} else {
			this.lastname = lastname;
		}
	}

	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) throws UserException {
		if(dob.isAfter(LocalDate.now())) {
			throw new UserException("La fecha de nacimiento no puede ser mayor a la fecha actual.");
		} else {
			this.dob = dob;
		}
	}


	public char getSex() {
		return sex;
	}


	public void setSex(char sex) throws UserException {
		if(Character.toUpperCase(sex) != 'M' && Character.toUpperCase(sex)!= 'H') {
			throw new UserException("El valor del sexo introducido no es válido.");
		} else {
			this.sex = sex;
		}
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name + ", lastname="
				+ lastname + ", dob=" + dob + ", sex=" + sex + ", admin=" + admin + "]";
	}
	
}
