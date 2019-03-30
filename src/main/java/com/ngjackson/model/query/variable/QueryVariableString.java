package com.ngjackson.model;

public class QueryVariableString extends QueryVariableType {

	public String getTypeName() {
		return "String";
	}

	public Object transformForSqlQuery(String value) {
		return value;
	}

	public boolean equals(Object other) {
		return false;
	}

}
