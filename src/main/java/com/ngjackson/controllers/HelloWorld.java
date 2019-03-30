package com.ngjackson.controllers;

import com.ngjackson.model.Query;
import com.ngjackson.util.QueryUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloWorld {

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

}
