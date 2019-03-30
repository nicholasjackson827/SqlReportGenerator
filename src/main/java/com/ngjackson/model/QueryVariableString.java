package com.ngjackson.model;

import com.ngjackson.model.QueryVariable;

public class QueryVariableString extends QueryVariable {
	public QueryVariable(String value) {
		super(value);
	}

	public String getType() {
		return "String";
	}

	public String getVariableSubstitution() {
		return "'" + value + "'";
	}
}
