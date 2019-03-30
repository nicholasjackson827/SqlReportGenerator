package com.ngjackson.model;

public class Query {

  private String id;
  private String query;

  public Query(String id, String query) {
    this.id = id;
    this.query = query;
  }

  public String getId() {
    return id;
  }

  public String getQuery() {
    return query;
  }

  @Override
  public String toString() {
    return "Query{" +
        "id='" + id + '\'' +
        ", query='" + query + '\'' +
        '}';
  }
}
