package com.ngjackson.model;

public abstract class QueryVariableType {

	public abstract String getTypeName();

	public abstract Object transformForSqlQuery(String value);

	public abstract boolean equals(Object other);

}
