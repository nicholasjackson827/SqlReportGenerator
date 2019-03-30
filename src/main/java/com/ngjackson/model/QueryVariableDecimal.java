package com.ngjackson.model;

import com.ngjackson.model.QueryVariable;

public class QueryVariableDecimal extends QueryVariable {
	public QueryVariable(String value) {
		super(value);
	}

	public String getType() {
		return "Decimal";
	}

	public String getVariableSubstitution() {
		return value;
	}
}
