package com.ngjackson.util;

import com.google.gson.Gson;
import com.ngjackson.model.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryUtil {

  @Value("${queries.json.filePath}")
  private String queriesJsonFilePath;

  public List<Query> getQueries() throws URISyntaxException, IOException {

    String queriesJson = getQueriesJson();

    Gson gson = new Gson();
    return Arrays.asList(gson.fromJson(queriesJson, Query[].class));
  }

  private String getQueriesJson() throws IOException, URISyntaxException {
    ClassPathResource resource = new ClassPathResource(this.queriesJsonFilePath);
    InputStream inputStream = resource.getInputStream();

    return new BufferedReader(new InputStreamReader(inputStream))
        .lines()
        .collect(Collectors.joining("\n"));
  }

}
