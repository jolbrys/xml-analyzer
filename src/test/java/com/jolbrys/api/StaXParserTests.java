package com.jolbrys.api;


import com.jolbrys.api.model.Row;
import com.jolbrys.api.utils.StaXParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class StaXParserTests {

    String url;

    @Test
    void testUrlArabic(){
        //given
        url = "https://s3-eu-west-1.amazonaws.com/merapar-assessment/arabic-posts.xml";

        Row expected = new Row();
        Row actual;

        expected.setId("1");
        expected.setPostTypeId("1");
        expected.setAcceptedAnswerId("5");
        expected.setCreationDate("2015-07-14T18:39:27.757");
        expected.setScore("4");
        expected.setViewCount("123");
        expected.setAnswerCount("5");
        expected.setCommentCount("4");

        //when
        actual = StaXParser.read(url).get(0);

        //then
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getPostTypeId(), actual.getPostTypeId());
        assertEquals(expected.getAcceptedAnswerId(), actual.getAcceptedAnswerId());
        assertEquals(expected.getCreationDate(), actual.getCreationDate());
        assertEquals(expected.getScore(), actual.getScore());
        assertEquals(expected.getViewCount(), actual.getViewCount());
        assertEquals(expected.getAnswerCount(), actual.getAnswerCount());
        assertEquals(expected.getCommentCount(), actual.getCommentCount());
    }

    @Test
    void testUrl3DPrints(){
        //given
        url = "https://s3-eu-west-1.amazonaws.com/merapar-assessment/3dprinting-posts.xml";

        Row expected = new Row();
        Row actual;

        expected.setId("1");
        expected.setPostTypeId("1");
        expected.setAcceptedAnswerId("51");
        expected.setCreationDate("2016-01-12T18:45:19.963");
        expected.setScore("4");
        expected.setViewCount("41");
        expected.setAnswerCount("1");
        expected.setCommentCount("3");

        //when
        actual = StaXParser.read(url).get(0);

        //then
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getPostTypeId(), actual.getPostTypeId());
        assertEquals(expected.getAcceptedAnswerId(), actual.getAcceptedAnswerId());
        assertEquals(expected.getCreationDate(), actual.getCreationDate());
        assertEquals(expected.getScore(), actual.getScore());
        assertEquals(expected.getViewCount(), actual.getViewCount());
        assertEquals(expected.getAnswerCount(), actual.getAnswerCount());
        assertEquals(expected.getCommentCount(), actual.getCommentCount());

    }
}
