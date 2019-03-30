package com.ngjackson.model;

public class QueryTemplate {

  private String id;
  private String queryTemplate;

  public QueryTemplate(String id, String queryTemplate) {
    this.id = id;
    this.queryTemplate = queryTemplate;
  }

  public String getId() {
    return id;
  }

  public String getQueryTemplate() {
    return queryTemplate;
  }

  @Override
  public String toString() {
    return "QueryTemplate{" +
        "id='" + id + '\'' +
        ", queryTemplate='" + query + '\'' +
        '}';
  }
}
