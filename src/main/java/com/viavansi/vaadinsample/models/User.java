package com.viavansi.vaadinsample.models;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class User implements Serializable {
    
	private static final long serialVersionUID = 9108474755053042201L;
	
	@NotNull
	Integer id;

	@NotNull
    String name;
    
    @NotNull
    String lastName;
    
    String company;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}