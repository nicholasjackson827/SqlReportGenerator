package com.ngjackson.controllers;

import com.ngjackson.model.Query;
import com.ngjackson.util.QueryUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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

}
