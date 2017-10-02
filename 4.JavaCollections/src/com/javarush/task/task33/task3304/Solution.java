package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(one);
        s = s.replaceFirst(one.getClass().getSimpleName().toLowerCase(), resultClassObject.getSimpleName().toLowerCase());
        Object result = mapper.readValue(s, resultClassObject);
        return result;
        /*StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, one);

        ObjectReader reader = mapper.reader();

        JsonNode node = reader.readTree(writer.toString());
        ObjectMapper mapper1 = new ObjectMapper();
        Map<String, Object> result = mapper1.convertValue(node, Map.class);
        String key1 = result.keySet().toArray()[0].toString();
        ((ObjectNode)node).put(key1,resultClassObject.getSimpleName().toLowerCase());

        StringReader stringReader = new StringReader(node.toString());
        Object result1 = mapper1.readValue(stringReader, resultClassObject);
        return result1;*/
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}
