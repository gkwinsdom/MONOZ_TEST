package com.monstarlab.domain.model;
import java.io.Serializable;
import java.util.Date;

public class TestModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}