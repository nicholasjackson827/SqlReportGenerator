package com.ngjackson.model;

import com.ngjackson.model.QueryVariable;

public class QueryVariableDate extends QueryVariable {
	public QueryVariableDate(String name, String value) {
		super(name, value);
	}

	public String getType() {
		return "Date";
	}

	public String getVariableSubstitution() {
		return value;
	}
}
