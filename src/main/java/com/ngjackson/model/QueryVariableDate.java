package com.ngjackson.model;

import com.ngjackson.model.QueryVariable;

public class QueryVariableDate extends QueryVariable {
	public QueryVariable(String value) {
		super(value);
	}

	public String getType() {
		return "Integer";
	}

	public String getVariableSubstitution() {
		return value;
	}
}
