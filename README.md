# XML-ANALYZER
Web application for analyzing and summarizing xml file content.

## Docker Instruction

To run application you need to get docker image from dockerhub and
run it using following commands:

```
docker pull jolbrys/xml-analyzer

docker run -p 9393:9393 jolbrys/xml-analyzer
```

Then you might want to test it using curl request, like:
```
curl -d "url=https://s3-eu-west-1.amazonaws.com/merapar-assessment/arabic-posts.xml" -X POST http://localhost:9393/analyze
```

In that case the response should look like below:
```
{
    "analyseDate": "2020-01-09T10:33:38.202",
    "details": {
        "firstPost": "2015-07-14T18:39:27.757",
        "lastPost": "2015-09-14T12:46:52.053",
        "totalPosts": 80,
        "totalAcceptedPosts": 7,
        "avgScore": 2.975,
        "topViewCount": 556,
        "avgViewCount": 83.71875,
        "topAnswerCount": 5,
        "avgAnswerCount": 1.5,
        "topCommentCount": 11,
        "avgCommentCount": 1.525
    }
}
```

## Flow

Application flow consists of 4 operations.

+ First the url is parsed to Java collection with read() method located in utils.StaXParser class.
+ Then analyze() method from utils.Analyzer performs analysis of xml's content and returns AnalysisDetails object.
+ prepare() method located in utils.Analyzer adds timestamp to details and returns Analysis object.
+ Finally, in Controller class, index() method puts Analysis object in an elegant JSON format and this is what is put in a response.

## Tests
Application is unit tested by 7 tests and code coverage looks like presented:

| Classes  |  Methods  |    Lines    |
|----------|-----------|-------------|
|100% (7/7)|90% (47/52)|89% (154/172)|

Component tests are not necessary, since application is single-component.
Still, some tests were performed via Postman mock server during development process.