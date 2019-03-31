package com.ngjackson.controllers;

import com.ngjackson.dao.impl.QueryExecutor;
import com.ngjackson.model.Query;
import com.ngjackson.model.QueryVariable;
import com.ngjackson.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class QueryController {

  @Autowired
  QueryExecutor queryExecutor;

  @RequestMapping("/")
  public String getIndex() {
    return "Hello world!";
  }

  @RequestMapping("/getQueries")
  public List<Query> getQueries() throws IOException {
    QueryUtil queryUtil = new QueryUtil();

    return queryUtil.getQueries();
  }

  @RequestMapping("/getQueryNames")
  public List<String> getQueryNames() throws IOException {

    List<Query> queries = new QueryUtil().getQueries();

    return queries
        .stream()
        .map(q -> q.getTemplate().getName())
        .distinct()
        .collect(Collectors.toList());
  }

  @RequestMapping("/getQuery/{id}")
  public Query getQuery(@PathVariable String id) throws IOException {

    return new QueryUtil().getQueryById(id);
  }

  @RequestMapping("/executeQuery/{id}")
  public List<Map<String, Object>> executeQuery(@PathVariable String id,
        @RequestParam Map<String, String> allRequestParams) throws IOException {

    Query query = new QueryUtil().getQueryById(id);

    Map<String, Object> variables = new HashMap<String, Object>();

    List<String> queryVariableNames = query
        .getVariables()
        .stream()
        .map(q -> q.getName())
        .collect(Collectors.toList());

    for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {


      // First, see if there's a variable with that name
      if (queryVariableNames.contains(entry.getKey())) {
        // Next, get the type and the value
        QueryVariable queryVariable = query.getVariables()
            .stream()
            .filter(q -> q.getName().equals(entry.getKey()))
            .findFirst()
            .get();

        String typeName = queryVariable.getType();

        // Convert the query variable to the actual type
        Object variableValue;
        switch (typeName.toLowerCase()) {
          case "string":
            variableValue = entry.getValue();
            break;
          case "integer":
            variableValue = Integer.valueOf(entry.getValue());
            break;
          case "boolean":
            variableValue = Boolean.valueOf(entry.getValue());
            break;
          case "decimal":
            variableValue = Double.valueOf(entry.getValue());
            break;
          case "date":
            variableValue = LocalDate.parse(entry.getValue());
            break;
          default:
            throw new IllegalStateException("Unknown variable type " + typeName);
        }

        variables.put(entry.getKey(), variableValue);
      }
    }

    return queryExecutor.executeQuery(query, variables);
  }

}
