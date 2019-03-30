package com.ngjackson.model;

public class QueryVariableInteger extends QueryVariableType {

	public String getTypeName() {
		return "Integer";
	}

	public Object transformForSqlQuery(String value) {
		return Integer.parseInt(value);
	}

	public boolean equals(Object other) {
		return false;
	}

}
