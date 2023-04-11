package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class JSONHelper {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();
    private static final Logger log = Logger.getLogger(JSONHelper.class.getName());

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return defaultObjectMapper;
    }

    public static <A> A fromJsonToObject(String name, Class<A> clazz) {
        try {
            JsonNode data = objectMapper.readTree(new File("src/test/java/testdata/"+name));
            return objectMapper.treeToValue(data,clazz);
        } catch (IOException e) {
            log.info("JSON could not be deserialized: " + e.getMessage());
        }
        return null;
    }

    public static Map<String,Object> fromObjectToMap(Object object) {
        return objectMapper.convertValue(object,Map.class);
    }

    public static List<Integer> fromJsonToList(String name) {
        try {
            return objectMapper.readValue(
                    new File("src/test/java/testdata/"+name),
                    new TypeReference<List<Integer>>(){});
        } catch (IOException e) {
            log.info("JSON could not be deserialized: " + e.getMessage());
        }
        return Collections.emptyList();
    }


}