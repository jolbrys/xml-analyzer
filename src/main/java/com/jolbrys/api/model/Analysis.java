package com.jolbrys.api.model;

public class Analysis {

    private String analyseDate;
    private AnalysisDetails details;

    public String getAnalyseDate() {
        return analyseDate;
    }

    public void setAnalyseDate(String analyseDate) {
        this.analyseDate = analyseDate;
    }

    public AnalysisDetails getDetails() {
        return details;
    }

    public void setDetails(AnalysisDetails details) {
        this.details = details;
    }
}
