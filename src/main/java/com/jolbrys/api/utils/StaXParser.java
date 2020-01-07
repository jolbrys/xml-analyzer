/*
* This is xml handling class made by refactoring code from this tutorial: https://www.vogella.com/tutorials/JavaXML/article.html
* */

package com.jolbrys.api.utils;

import com.jolbrys.api.model.Row;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaXParser {

    static final String ROW = "row";

    static final String ID = "Id";
    static final String POST_TYPE_ID = "PostTypeId";
    static final String ACCEPTED_ANSWER_ID ="AcceptedAnswerId";
    static final String CREATION_DATE = "CreationDate";
    static final String SCORE = "Score";
    static final String VIEW_COUNT = "ViewCount";
    static final String ANSWER_COUNT = "AnswerCount";
    static final String COMMENT_COUNT = "CommentCount";

    @SuppressWarnings({ "unchecked", "null" })
    public static List<Row> read(String filepath_url) {
        List<Row> rows = new ArrayList<Row>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new URL(filepath_url).openStream();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Row row = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have a row element, we create a new row
                    if (startElement.getName().getLocalPart().equals(ROW)) {
                        row = new Row();
                        //read the attributes from this tag and add attributes to object
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(ID)) {
                                row.setId(attribute.getValue());
                                continue;
                            }
                            if (attribute.getName().toString().equals(POST_TYPE_ID)) {
                                row.setPostTypeId(attribute.getValue());
                                continue;
                            }
                            if (attribute.getName().toString().equals(ACCEPTED_ANSWER_ID)) {
                                row.setAcceptedAnswerId(attribute.getValue());
                                continue;
                            }
                            if (attribute.getName().toString().equals(CREATION_DATE)) {
                                row.setCreationDate(attribute.getValue());
                                continue;
                            }
                            if (attribute.getName().toString().equals(SCORE)) {
                                row.setScore(attribute.getValue());
                                continue;
                            }
                            if (attribute.getName().toString().equals(VIEW_COUNT)) {
                                row.setViewCount(attribute.getValue());
                                continue;
                            }
                            if (attribute.getName().toString().equals(ANSWER_COUNT)) {
                                row.setAnswerCount(attribute.getValue());
                                continue;
                            }
                            if (attribute.getName().toString().equals(COMMENT_COUNT)) {
                                row.setCommentCount(attribute.getValue());
                            }

                        }
                    }

                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(ROW)) {
                        rows.add(row);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
