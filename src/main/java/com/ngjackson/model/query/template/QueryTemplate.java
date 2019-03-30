package com.ngjackson.model;

public class QueryTemplate {

  private String name;
  private String sqlTemplate;
  private Collection<QueryVariableDefinition> variableDefinitions;
  private Map<String, QueryVariableDefinition> variableDefinitionsByName;

  public QueryTemplate(String name, String sqlTemplate, Collection<QueryVariableDefinition> variableDefinitions) {
	  this.name = name;
    this.sqlTemplate = sqlTemplate;
    this.variableDefinitions = variableDefinitions;
    this.variableDefinitionsByName = variableDefinitions.stream()
	    .collect(Collectors.toMap(d -> d.getName(), d -> d);
  }

  public String getName() {
    return name;
  }

  public String getSqlTemplate() {
    return sqlTemplate;
  }

  public QueryVariableDefinition getVariableDefinition(String name) {
	  return variableDefinitionsByName.get(name);
  }

  public Query createQuery(Map<String, String> variableValues) {
  }

  @Override
  public String toString() {
    return "QueryTemplate{" +
        "name='" + name + '\'' +
        ", sqlTemplate='" + sqlTemplate + '\'' +
        '}';
  }
}
