package com.jolbrys.api;

import com.jolbrys.api.model.AnalysisDetails;
import com.jolbrys.api.model.Row;
import com.jolbrys.api.utils.Analyzer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class AnalyzerTests {

    Analyzer analyzer = new Analyzer();

    private String firstPost = "2015-07-14T18:39:27.757";
    private String lastPost = "2015-09-14T12:46:52.053";
    private int totalPosts = 80;
    private int totalAcceptedPosts = 8;
    private double avgScore = 2.975;
    private int topViewCount = 556;
    private double avgViewCount = 83.71875;
    private int topAnswerCount = 5;
    private double avgAnswerCount = 1.5;
    private int topCommentCount = 11;
    private double avgCommentCount = 1.525;

    private Row row1 = new Row();
    private Row row2 = new Row();
    private Row row3 = new Row();

    private String id1 = "1";
    private String postTypeId1 = "1";
    private String acceptedAnswerId1 = "5";
    private String creationDate1 = "2016-01-12T18:53:53.623";
    private String score1 = "5";
    private String viewCount1 = "8";
    private String answerCount1 = "4";
    private String commentCount1 = "2";

    private String id2 = "2";
    private String postTypeId2 = "1";
    private String acceptedAnswerId2;
    private String creationDate2 = "2016-03-14T18:53:53.623";
    private String score2 = "10";
    private String viewCount2 = "13";
    private String answerCount2 = "9";
    private String commentCount2 = "7";

    private String id3 = "3";
    private String postTypeId3 = "1";
    private String acceptedAnswerId3 = "5";
    private String creationDate3 = "2016-06-21T18:53:53.623";
    private String score3 = "20";
    private String viewCount3 = "25";
    private String answerCount3 = "11";
    private String commentCount3 = "4";

    @Test
    void validatePrepareTimestamp(){
        //given
        AnalysisDetails details = new AnalysisDetails();
        details.setFirstPost(firstPost);
        details.setLastPost(lastPost);
        details.setTotalPosts(totalPosts);
        details.setTotalAcceptedPosts(totalAcceptedPosts);
        details.setAvgScore(avgScore);
        details.setTopViewCount(topViewCount);
        details.setAvgViewCount(avgViewCount);
        details.setTopAnswerCount(topAnswerCount);
        details.setAvgAnswerCount(avgAnswerCount);
        details.setTopCommentCount(topCommentCount);
        details.setAvgCommentCount(avgCommentCount);

        //when
        LocalDateTime date = LocalDateTime.parse(analyzer.prepare(details).getAnalyseDate());

        //then
        assertTrue(date.isBefore(LocalDateTime.now()) || date.isEqual(date));
    }

    @Test
    void validateAnalysis(){
        //given
        row1.setId(id1);
        row1.setPostTypeId(postTypeId1);
        row1.setAcceptedAnswerId(acceptedAnswerId1);
        row1.setCreationDate(creationDate1);
        row1.setScore(score1);
        row1.setViewCount(viewCount1);
        row1.setAnswerCount(answerCount1);
        row1.setCommentCount(commentCount1);

        row2.setId(id2);
        row2.setPostTypeId(postTypeId2);
        row2.setAcceptedAnswerId(acceptedAnswerId2);
        row2.setCreationDate(creationDate2);
        row2.setScore(score2);
        row2.setViewCount(viewCount2);
        row2.setAnswerCount(answerCount2);
        row2.setCommentCount(commentCount2);

        row3.setId(id3);
        row3.setPostTypeId(postTypeId3);
        row3.setAcceptedAnswerId(acceptedAnswerId3);
        row3.setCreationDate(creationDate3);
        row3.setScore(score3);
        row3.setViewCount(viewCount3);
        row3.setAnswerCount(answerCount3);
        row3.setCommentCount(commentCount3);

        List<Row> rows = new ArrayList<Row>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        //when
        AnalysisDetails expected = new AnalysisDetails();
        expected.setFirstPost("2016-01-12T18:53:53.623");
        expected.setLastPost("2016-06-21T18:53:53.623");
        expected.setTotalPosts(3);
        expected.setTotalAcceptedPosts(2);
        expected.setAvgScore(11.666666666666666);
        expected.setTopViewCount(25);
        expected.setAvgViewCount(15.333333333333334);
        expected.setTopAnswerCount(11);
        expected.setAvgAnswerCount(8.0);
        expected.setTopCommentCount(7);
        expected.setAvgCommentCount(4.333333333333333);

        AnalysisDetails actual = analyzer.analyze(rows);

        //then
        assertEquals(actual.getFirstPost(), expected.getFirstPost());
        assertEquals(actual.getLastPost(), expected.getLastPost());
        assertEquals(actual.getTotalPosts(), expected.getTotalPosts());
        assertEquals(actual.getTotalAcceptedPosts(), expected.getTotalAcceptedPosts());
        assertEquals(actual.getAvgScore(), expected.getAvgScore());
        assertEquals(actual.getTopViewCount(), expected.getTopViewCount());
        assertEquals(actual.getAvgViewCount(), expected.getAvgViewCount());
        assertEquals(actual.getTopAnswerCount(), expected.getTopAnswerCount());
        assertEquals(actual.getAvgAnswerCount(), expected.getAvgAnswerCount());
        assertEquals(actual.getAvgCommentCount(), expected.getAvgCommentCount());
    }

    @Test
    void validateAnalysisWithNullsInSummaries(){
        //given
        row1.setId(id1);
        row1.setPostTypeId(postTypeId1);
        row1.setAcceptedAnswerId(acceptedAnswerId1);
        row1.setCreationDate(creationDate1);
        row1.setScore(score1);
        row1.setViewCount(viewCount1);
        row1.setAnswerCount(answerCount1);
        row1.setCommentCount(commentCount1);

        row2.setId(id2);
        row2.setPostTypeId(postTypeId2);
        row2.setAcceptedAnswerId(acceptedAnswerId2);
        row2.setCreationDate(creationDate2);
        row2.setScore(score2);
        row2.setViewCount(viewCount2);
        row2.setAnswerCount(answerCount2);
        row2.setCommentCount(commentCount2);

        row3.setId(id3);
        row3.setPostTypeId(postTypeId3);
        row3.setAcceptedAnswerId(acceptedAnswerId3);
        row3.setCreationDate(creationDate3);

        List<Row> rows_fullonly = new ArrayList<Row>();
        rows_fullonly.add(row1);
        rows_fullonly.add(row2);

        List<Row> rows_all = new ArrayList<Row>();
        rows_all.add(row1);
        rows_all.add(row2);
        rows_all.add(row3);

        //when
        AnalysisDetails expected = analyzer.analyze(rows_fullonly);
        AnalysisDetails actual = analyzer.analyze(rows_all);

        //then
        assertEquals(actual.getAvgScore(), expected.getAvgScore());
        assertEquals(actual.getTopViewCount(), expected.getTopViewCount());
        assertEquals(actual.getAvgViewCount(), expected.getAvgViewCount());
        assertEquals(actual.getTopAnswerCount(), expected.getTopAnswerCount());
        assertEquals(actual.getAvgAnswerCount(), expected.getAvgAnswerCount());
        assertEquals(actual.getAvgCommentCount(), expected.getAvgCommentCount());
    }
}
