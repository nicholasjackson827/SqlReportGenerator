package com.ngjackson.model;

import com.ngjackson.model.QueryVariableType;

public class QueryVariableDefinition {
	QueryVariableType type;
	String name;

	public QueryVariableDefinition(QueryVariableType type, String name) {
		this.type = type;
		this.name = name;
	}

	public QueryVariableType getType() {
		return type;
	}
	public String getName() {
		return name;
	}

	public QueryVariable createVariable(String value) {
		return new QueryVariable(this, value);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof QueryVariableDefinition)
				|| !(o.getType.equals(type) && o.getName().equals(name))) {
			return false;
		}
		return true; // same type and values match
	}
}
