package com.dropwizard.example.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ExampleResponse {
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();


        //Serialization => From class to JSON
        ExampleResponse response = new ExampleResponse();
        response.setId(1);
        response.setContent("Hi Shefali");
        String json1 = objectMapper.writeValueAsString(response);
        System.out.println(json1);

        //De serialization
        String json2 = "{\"id\":1,\"content\":\"Hi Shefali\"}";

        ExampleResponse resp = objectMapper.readValue(json2, ExampleResponse.class);
        System.out.println(resp.getId());
        System.out.println(resp.getContent());
    }
}
