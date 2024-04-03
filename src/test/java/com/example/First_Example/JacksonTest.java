package com.example.First_Example;

import com.example.First_Example.domain.entities.AuthorEntity;
import com.example.First_Example.domain.entities.BookEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTest {
    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthorEntity authorEntity = AuthorEntity.builder().id(1L).age(27).name("ogun").build();
        BookEntity bookEntity = BookEntity.builder()
                .isbn("978-0-13-478627-5")
                .title("The Enigma of Eternity")
                .authorEntity(authorEntity)
                .build();
        String result = objectMapper.writeValueAsString(bookEntity);
        assertThat(result).isEqualTo("{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"authorEntity\":{\"id\":1,\"name\":\"ogun\",\"age\":27}}");
    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObjects() throws JsonProcessingException {
        AuthorEntity authorEntity = AuthorEntity.builder().id(1L).age(27).name("ogun").build();
        BookEntity bookEntity = BookEntity.builder()
                .isbn("978-0-13-478627-5")
                .title("The Enigma of Eternity")
                .authorEntity(authorEntity)

                .build();
        String Json = "{\"foo\":\"bar\", \"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"authorEntity\":{\"id\":1,\"name\":\"ogun\",\"age\":27}}";
        final ObjectMapper objectMapper = new ObjectMapper();
        BookEntity result = objectMapper.readValue(Json, BookEntity.class);
        assertThat(result).isEqualTo(bookEntity);
    }
}
