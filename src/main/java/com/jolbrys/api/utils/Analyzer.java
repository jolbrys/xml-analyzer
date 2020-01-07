package com.jolbrys.api.utils;

import com.jolbrys.api.model.Analysis;
import com.jolbrys.api.model.AnalysisDetails;
import com.jolbrys.api.model.Row;

import java.time.LocalDateTime;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analyzer {

    public Analysis prepare(AnalysisDetails details){
        Analysis analysis = new Analysis();

        analysis.setAnalyseDate(LocalDateTime.now().toString());
        analysis.setDetails(details);

        return analysis;
    }

    public AnalysisDetails analyze(List<Row> rows) {

        AnalysisDetails details = new AnalysisDetails();

        String firstPost;
        String lastPost;
        int totalPosts;
        int totalAcceptedPosts;
        double avgScore;
        int topViewCount;
        double avgViewCount;
        int topAnswerCount;
        double avgAnswerCount;
        int topCommentCount;
        double avgCommentCount;

        IntSummaryStatistics summary_answer = rows.stream().map(Row::getAnswerCount).filter(Objects::nonNull).mapToInt(Integer::parseInt).summaryStatistics();
        IntSummaryStatistics summary_view = rows.stream().map(Row::getViewCount).filter(Objects::nonNull).mapToInt(Integer::parseInt).summaryStatistics();
        IntSummaryStatistics summary_comment = rows.stream().map(Row::getCommentCount).filter(Objects::nonNull).mapToInt(Integer::parseInt).summaryStatistics();
        IntSummaryStatistics summary_score = rows.stream().map(Row::getScore).filter(Objects::nonNull).mapToInt(Integer::parseInt).summaryStatistics();
        List<LocalDateTime> post_dates = rows.stream().map(Row::getCreationDate).map(LocalDateTime::parse).sorted().collect(Collectors.toList());

        avgScore = summary_score.getAverage();
        topViewCount = summary_view.getMax();
        avgViewCount = summary_view.getAverage();
        topAnswerCount = summary_answer.getMax();
        avgAnswerCount = summary_answer.getAverage();
        topCommentCount = summary_comment.getMax();
        avgCommentCount = summary_comment.getAverage();
        totalPosts = rows.size();
        totalAcceptedPosts = (int) rows.stream().map(Row::getAcceptedAnswerId).filter(Objects::nonNull).count();
        firstPost = post_dates.get(0).toString();
        lastPost = post_dates.get(totalPosts-1).toString();

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

        return details;
    }
}
