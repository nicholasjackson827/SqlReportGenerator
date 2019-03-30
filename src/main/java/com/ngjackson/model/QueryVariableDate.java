package com.ngjackson.model;

public class QueryVariableDate extends QueryVariable {

	public QueryVariableDate(String value) {
		super(value);
	}

	public String getType() {
		return "Date";
	}

	public String getVariableSubstitution() {
		return value;
	}
}
