package com.ngjackson.dao.impl;

import com.ngjackson.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QueryExecutorImpl implements QueryExecutor {

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<Map<String, Object>> executeQuery(Query query, Map<String, Object> variableValues) {

    String sql = query.getTemplate().getSql();

    MapSqlParameterSource params = new MapSqlParameterSource();

    if (query.getVariables() != null && query.getVariables().size() > 0) {
      for (Map.Entry<String, Object> entry : variableValues.entrySet()) {
        params.addValue(entry.getKey(), entry.getValue());
      }
    }

    return namedParameterJdbcTemplate.queryForList(sql, params);

  }

}
