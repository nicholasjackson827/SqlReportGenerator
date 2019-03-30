package com.ngjackson.model;

import java.util.Collection;

public class Query {

	QueryTemplate template;
	Collection<QueryVariable> variables;

	public Query(QueryTemplate template, Collection<QueryVariable> variables) {
    this.template = template;
    this.variables = variables;
  }

  public QueryTemplate getTemplate() {
    return template;
  }

  public Collection<QueryVariable> getVariables() {
    return Collections.unmodifiableCollection(variables);
  }

  public List<Map<String, Object>> executeQuery(NamedParameterJdbcTemplate jdbcTemplate) {
	  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	  variables.stream().forEach(v -> v.prepareSql(parameterSource));
				     
	  try {
	  	return jdbcTemplate.queryForList(template.getSqlTemplate()
						 , parameterSource);
	  } catch (DataAccessException e) {
		  throw e;
	  }
  }
  

  @Override
  public String toString() {
    return "Query {" +
        "template=" + template +
        ", variables=" + variables +
        '}';
  }
}
