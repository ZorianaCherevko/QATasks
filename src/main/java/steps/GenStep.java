package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.SneakyThrows;


public class GenStep  {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public String getBodyValue(Response response, String key){
        return objectMapper.readTree(response.getBody().asString()).at(key).asText();
    }

    @SneakyThrows
    public int getBodyValueInt(Response response, String key){
        return objectMapper.readTree(response.getBody().asString()).at(key).asInt();
    }

}
