package com.skilldistillery.languages.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;

	private String password;
	
	private boolean isActive;

	private String mainLocation;

	
	public User() {
		super();
	}

	
	public User(int id, String username, String password, boolean isActive, String mainLocation) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.mainLocation = mainLocation;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getMainLocation() {
		return mainLocation;
	}

	public void setMainLocation(String mainLocation) {
		this.mainLocation = mainLocation;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((mainLocation == null) ? 0 : mainLocation.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
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
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (mainLocation == null) {
			if (other.mainLocation != null)
				return false;
		} else if (!mainLocation.equals(other.mainLocation))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", username=").append(username).append(", password=")
				.append(password).append(", isActive=").append(isActive).append(", mainLocation=").append(mainLocation)
				.append("]");
		return builder.toString();
	}
}
	