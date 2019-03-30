package com.ngjackson.model;

public class QueryVariableDate extends QueryVariableType {

	public String getTypeName() {
		return "Date";
	}

	public Object transformForSqlQuery(String value) {
		return new java.util.Date(value);
	}

	public boolean equals(Object other) {
		return false;
	}

}
