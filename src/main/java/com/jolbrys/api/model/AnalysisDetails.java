package com.jolbrys.api.model;

public class AnalysisDetails {

    private String firstPost;
    private String lastPost;
    private int totalPosts;
    private int totalAcceptedPosts;
    private double avgScore;
    private int topViewCount;
    private double avgViewCount;
    private int topAnswerCount;
    private double avgAnswerCount;
    private int topCommentCount;
    private double avgCommentCount;

    @Override
    public String toString() {
        return "Details: " +
                "\nfirst post= " + firstPost +
                "\nlast post= " + lastPost +
                "\ntotal posts= " + totalPosts +
                "\ntotal accepted posts= " + totalAcceptedPosts +
                "\navg score= " + avgScore +
                "\ntop view count= " + topViewCount +
                "\navg view count= " + avgViewCount +
                "\ntop answer count= " + topAnswerCount +
                "\navg answer count= " + avgAnswerCount +
                "\ntop comment count= " + topCommentCount +
                "\navg comment count= " + avgCommentCount;
    }

    public int getTopViewCount() {
        return topViewCount;
    }

    public void setTopViewCount(int topViewCount) {
        this.topViewCount = topViewCount;
    }

    public double getAvgViewCount() {
        return avgViewCount;
    }

    public void setAvgViewCount(double avgViewCount) {
        this.avgViewCount = avgViewCount;
    }

    public int getTopAnswerCount() {
        return topAnswerCount;
    }

    public void setTopAnswerCount(int topAnswerCount) {
        this.topAnswerCount = topAnswerCount;
    }

    public double getAvgAnswerCount() {
        return avgAnswerCount;
    }

    public void setAvgAnswerCount(double avgAnswerCount) {
        this.avgAnswerCount = avgAnswerCount;
    }

    public int getTopCommentCount() {
        return topCommentCount;
    }

    public void setTopCommentCount(int topCommentCount) {
        this.topCommentCount = topCommentCount;
    }

    public double getAvgCommentCount() {
        return avgCommentCount;
    }

    public void setAvgCommentCount(double avgCommentCount) {
        this.avgCommentCount = avgCommentCount;
    }

    public String getFirstPost() {
        return firstPost;
    }

    public void setFirstPost(String firstPost) {
        this.firstPost = firstPost;
    }

    public String getLastPost() {
        return lastPost;
    }

    public void setLastPost(String lastPost) {
        this.lastPost = lastPost;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public int getTotalAcceptedPosts() {
        return totalAcceptedPosts;
    }

    public void setTotalAcceptedPosts(int totalAcceptedPosts) {
        this.totalAcceptedPosts = totalAcceptedPosts;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}



