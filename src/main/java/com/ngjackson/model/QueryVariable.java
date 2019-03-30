package com.ngjackson.model;

public class QueryVariable {
	public String value;

	public QueryVariable(String value) {
		this.value = value;
	}

	public abstract String getType();
	public abstract String getVariableSubstitution();
}
