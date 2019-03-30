package com.ngjackson.model;

import com.ngjackson.model.QueryVariable;

public class QueryVariableString extends QueryVariable {
	public QueryVariableString(String name, String value) {
		super(name, value);
	}

	public String getType() {
		return "String";
	}

	public String getVariableSubstitution() {
		return "'" + value + "'";
	}
}
