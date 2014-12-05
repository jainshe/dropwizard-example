package com.dropwizard.example;

import com.dropwizard.example.bean.ExampleResponse;
import com.ning.http.client.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DropwizardExampleTest extends BaseTest {
    private static String url = "http://localhost:8080/hello-world";

    /**
     * Test 1
     * URL: http://localhost:8080/hello-world
     * Method: GET
     * Response code: 200
     */

    @Test
    public void test_one() throws ExecutionException, InterruptedException, IOException {
        Future<Response> f = asyncHttpClient.prepareGet(url).execute();
        Response response = f.get();

        //Same
        int statusCode = response.getStatusCode();
        String respBody = response.getResponseBody();
        Assert.assertEquals(statusCode, 200);

        ExampleResponse resp = objectMapper.readValue(respBody, ExampleResponse.class);
        Assert.assertEquals(resp.getContent(), "Hello, Stranger!");
        Assert.assertTrue(resp.getId() > 0);
    }

    /**
     * Test 2
     * URL: http://localhost:8080/hello-world?name=Shefali
     * Method: GET
     * Response code: 200
     */

    @Test
    public void test_two() throws ExecutionException, InterruptedException, IOException {
        String queryParam = RandomStringUtils.randomAlphabetic(10);
        Future<Response> f = asyncHttpClient.prepareGet(url).addQueryParam("name", queryParam).execute();
        Response response = f.get();

        int statusCode = response.getStatusCode();
        String respBody = response.getResponseBody();
        Assert.assertEquals(statusCode, 200);

        ExampleResponse resp = objectMapper.readValue(respBody, ExampleResponse.class);
        Assert.assertEquals(resp.getContent(), "Hello, " + queryParam + "!");
        Assert.assertTrue(resp.getId() > 0);
    }

}
