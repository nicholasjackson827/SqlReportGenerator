package com.ngjackson.model;

import com.ngjackson.model.QueryVariable;

public class QueryVariableInteger extends QueryVariable {

	public QueryVariableInteger(String value) {
		super(value);
	}

	public String getType() {
		return "Integer";
	}

	public String getVariableSubstitution() {
		return value;
	}
}
