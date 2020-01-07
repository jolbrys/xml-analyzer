package com.jolbrys.api;

import com.google.gson.Gson;
import com.jolbrys.api.model.AnalysisDetails;
import com.jolbrys.api.utils.Analyzer;
import com.jolbrys.api.utils.StaXParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public static String INVALID_URL_MESSAGE = "url is invalid";

    @RequestMapping("/analyze")
    public String index(@RequestParam String url) {
        try {
            Analyzer analyzer = new Analyzer();
            AnalysisDetails details = analyzer.analyze(StaXParser.read(url));
            return new Gson().toJson(analyzer.prepare(details));
        }
        catch(Exception e){
            return INVALID_URL_MESSAGE;
        }
    }
}
