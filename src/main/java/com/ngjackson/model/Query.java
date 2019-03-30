package com.ngjackson.model;

import java.util.Collection;

public class Query {

  Collection<QueryVariable> variables;
  QueryTemplate template;

	public Query(QueryTemplate template, Collection<QueryVariable> variables) {
    this.template = template;
    this.variables = variables;
  }

  public QueryTemplate getTemplate() {
    return template;
  }

  public Collection<QueryVariable> getVariables() {
    return variables;
  }

  @Override
  public String toString() {
    return "Query {" +
        "template=" + template +
        ", variables=" + variables +
        '}';
  }
}
