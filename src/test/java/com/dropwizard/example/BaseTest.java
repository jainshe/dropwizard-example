package com.dropwizard.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static ObjectMapper objectMapper;
    protected static AsyncHttpClient asyncHttpClient;

    @BeforeClass
    public void beforeClass() {
        objectMapper = new ObjectMapper();
        asyncHttpClient = new AsyncHttpClient();
    }

    @AfterClass
    public void afterClass() {
        asyncHttpClient.close();
    }

}
