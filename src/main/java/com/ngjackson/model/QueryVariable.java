package com.ngjackson.model;

public abstract class QueryVariable {
	public String name;
	public String value;

	public QueryVariable(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}


	public abstract String getType();
	public abstract String getVariableSubstitution();
}
