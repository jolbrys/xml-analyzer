package com.jolbrys.api.model;

public class Row {

    private String id;
    private String postTypeId;
    private String acceptedAnswerId;
    private String creationDate;
    private String score;
    private String viewCount;
    private String answerCount;
    private String commentCount;

    @Override
    public String toString() {
        return "Row: " +
                "\nId= " + id +
                "\nPostTypeId= " + postTypeId +
                "\nAcceptedAnswerId= " + acceptedAnswerId +
                "\nCreationDate= " + creationDate +
                "\nScore= " + score +
                "\nViewCount= " + viewCount +
                "\nAnswerCount= " + answerCount +
                "\nCommentCount= " + commentCount +
                "\n\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(String postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(String acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(String answerCount) {
        this.answerCount = answerCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }
}
