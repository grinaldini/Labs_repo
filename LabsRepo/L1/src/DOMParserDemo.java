import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.*;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class DOMParserDemo {
    public static void main(String[] args) {
//Get the DOM Builder Factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
//Get the DOM Builder
            DocumentBuilder builder = factory.newDocumentBuilder();
//Load and Parse the XML document
//document contains the complete XML as a Tree
            File relative = Paths.get("L1/","src","dblp-soc-papers.xml").normalize().toFile();
            Document document = builder.parse(relative); //Iterating through the nodes and extracting the data
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            List<Paper> paperList = new ArrayList<Paper>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Paper paper = new Paper();
                    Vector v = new Vector(3,2);
                    paper.inproceedings = node.getAttributes().getNamedItem("key").getNodeValue();
                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode instanceof Element) {
                            String content = childNode.getLastChild().getTextContent().trim();
                            if (childNode.getNodeName().equals("author")) {
                                paper.author.addElement(content);
                            } else if (childNode.getNodeName().equals("title")) {
                                paper.title = content;
                            } else if (childNode.getNodeName().equals("pages")) {
                                paper.pages = content;
                            } else if (childNode.getNodeName().equals("year")) {
                                paper.year = content;
                            } else if (childNode.getNodeName().equals("crossref")) {
                                paper.crossref = content;
                            } else if (childNode.getNodeName().equals("journal")){
                                paper.journal = content;
                            } else if (childNode.getNodeName().equals("booktitle")) {
                                paper.booktitle = content;
                            } else if (childNode.getNodeName().equals("volume")){
                                paper.journalVolume = content;
                            } else if (childNode.getNodeName().equals("number")){
                                paper.journalNumber = content;
                            } else if (childNode.getNodeName().equals("ee")){
                                paper.ee = content;
                            } else if (childNode.getNodeName().equals("url")) {
                                paper.url = content;
                            }
                        }
                    }
                    paperList.add(paper);
                }

            }


            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lab1", "root", "201269")) {

                if (conn != null) {
                    System.out.println("Connected to the database!");
                    String query = " insert into lab1tbl ( inproceedings, author, title, pages, year, crossref, journal, booktitle, journalVolume, journalNumber, ee, url)";
                    query +=" values( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";

                    int index = 0;

                    for(Paper p : paperList){
                        PreparedStatement cmd = conn.prepareStatement(query);
                        cmd.setString(1, p.inproceedings);
                        //what can we use instead of json? the goal is to have all names inside author column, make sense?
                        //author1 || author2 ||
                        String[] arr = new String[p.author.size()];
                        Iterator iter = p.author.iterator();
                        int ii = 0;
                        while(iter.hasNext()){
                            arr[ii] = iter.next().toString();
                            ii++;
                        }
                        String strAuthor = String.join("||", arr);
                        cmd.setObject(2, strAuthor);
                        cmd.setString(3, p.title);
                        cmd.setString(4, p.pages);
                        cmd.setString(5, p.year);
                        cmd.setString(6, p.crossref);
                        cmd.setString(7,p.journal);
                        cmd.setString(8, p.booktitle);
                        cmd.setString(9, p.journalVolume);
                        cmd.setString(10, p.journalNumber);
                        cmd.setString(11, p.ee);
                        cmd.setString(12, p.url);
                        index++;
                        cmd.addBatch();
                        cmd.executeBatch();
                        System.out.println(cmd);
                    }
                    System.out.println("End");
                    conn.close();
                } else {
                    System.out.println("Failed to make connection!");
                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

