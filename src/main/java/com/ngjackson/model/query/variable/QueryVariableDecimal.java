package com.ngjackson.model;

public class QueryVariableDecimal extends QueryVariableType {

	public String getTypeName() {
		return "Decimal";
	}

	public Object transformForSqlQuery(String value) {
		return Double.parseDouble(value);
	}

	public boolean equals(Object other) {
		return false;
	}

}
