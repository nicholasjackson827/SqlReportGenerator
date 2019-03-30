package com.ngjackson.dao.impl;

import com.ngjackson.model.Query;

import java.util.List;
import java.util.Map;

public interface QueryExecutor {

  public List<Map<String, Object>> executeQuery(Query query);

}
