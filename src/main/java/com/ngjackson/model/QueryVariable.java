package com.ngjackson.model;

public class QueryVariable {
	
	public String name;
	public String type;

	public QueryVariable(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "QueryVariable{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
