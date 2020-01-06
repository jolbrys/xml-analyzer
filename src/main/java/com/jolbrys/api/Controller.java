package com.jolbrys.api;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @RequestMapping("/")
    public String index(@RequestParam String url) {
        String response;
        Analysis analysis = new Analysis();
        AnalysisDetails details;
        StaXParser read = new StaXParser();
        Gson gson = new Gson();

        List<Row> readConfig = read.readConfig(url);
        details = analyze(readConfig);

        analysis.setAnalyseDate(LocalDateTime.now().toString());
        analysis.setDetails(details);
        response = gson.toJson(analysis);

        return response;
    }

    private AnalysisDetails analyze(List<Row> rows) {

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
        List<LocalDateTime> post_dates = rows.stream().map(Row::getCreationDate).map(LocalDateTime::parse).collect(Collectors.toList());
        Collections.sort(post_dates);

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
