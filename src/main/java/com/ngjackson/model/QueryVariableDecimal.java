package com.ngjackson.model;

import com.ngjackson.model.QueryVariable;

public class QueryVariableDecimal extends QueryVariable {
	public QueryVariableDecimal(String name, String value) {
		super(name, value);
	}

	public String getType() {
		return "Decimal";
	}

	public String getVariableSubstitution() {
		return value;
	}
}
