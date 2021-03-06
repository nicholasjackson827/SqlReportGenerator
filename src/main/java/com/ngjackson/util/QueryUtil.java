package com.ngjackson.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ngjackson.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A util with various methods regarding queries.
 */
public class QueryUtil {

  @Autowired
  private Environment env;

  /**
   * Gets the Query object from the queries JSON file.
   *
   * @return A list of Query objects
   * @throws IOException if we're unable to read the file
   */
  public List<Query> getQueries() throws IOException {

    Gson gson = new Gson();

    String queriesJson = getQueriesJson();

    // Create a parser and parse the JSON object
    JsonParser parser = new JsonParser();
    JsonObject queriesJsonObject = parser.parse(queriesJson).getAsJsonObject();

    // Query down one level so we don't need a "queryTemplates" object
    JsonArray queryTemplates = queriesJsonObject.get("queryTemplates").getAsJsonArray();

    // Convert that JSON array to the POJOs
    return Arrays.asList(gson.fromJson(queryTemplates, Query[].class));
  }

  /**
   * Gets a query by an ID.
   *
   * @param id The ID of the query to find
   * @return The query, null if it doesn't exist
   * @throws IOException if we're unable to read the queries JSON file
   */
  public Query getQueryById(String id) throws IOException {
    List<Query> queries = new QueryUtil().getQueries();

    return queries
        .stream()
        .filter(q -> q.getTemplate().getId().equals(id))
        .findFirst()
        .orElseGet(null);
  }

  /**
   * Gets the JSON for the queries.
   *
   * @return A string with the JSON object
   * @throws IOException if we're unable to read the file
   */
  private String getQueriesJson() throws IOException {

    ClassPathResource resource = new ClassPathResource("queries.json");
    InputStream inputStream = resource.getInputStream();

    return new BufferedReader(new InputStreamReader(inputStream))
        .lines()
        .collect(Collectors.joining("\n"));
  }

}
