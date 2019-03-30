package com.ngjackson.model;

import com.ngjackson.model.QueryVariableType;

public class QueryVariable {
	
	private QueryVariableDefinition definition;
	private String value;

	public QueryVariable(QueryVariableDefinition definition, String value) {
		this.definition = definition;
		this.value = value;
	}

	public QueryVariableDefinition getQueryVariableDefinition() { return definition;}

	public String getValue() {
		return value;
	}

	public void prepareVariable(MapSqlParameterSource source) {
		source.addValue(definition.getName(), definition.getType()
				.transformForSqlQuery(value));
	}

}
