package com.ngjackson.model;

public class QueryTemplate {

  private String name;
  private String queryTemplate;
  private Collection<QueryVariableDefinition> variableDefinitions;
  private Map<String, QueryVariableDefinition> variableDefinitionsByName;

  public QueryTemplate(String name, String queryTemplate, Collection<QueryVariableDefinition> variableDefinitions) {
	  this.name = name;
    this.queryTemplate = queryTemplate;
    this.variableDefinitions = variableDefinitions;
    this.variableDefinitionsByName = variableDefinitions.stream()
	    .collect(Collectors.toMap(d -> d.getName(), d -> d);
  }

  public String getName() {
    return name;
  }

  public String getQueryTemplate() {
    return queryTemplate;
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
        ", queryTemplate='" + queryTemplate + '\'' +
        '}';
  }
}
