package com.ngjackson.model;

public class QueryTemplate {

  private String id;
  private String name;
  private String sql;

  public QueryTemplate(String name, String sql) {
    this.name = name;
    this.sql = sql;
  }

  public String getName() {
    return name;
  }

  public String getSql() {
    return sql;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "QueryTemplate{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", sql='" + sql + '\'' +
        '}';
  }
}
