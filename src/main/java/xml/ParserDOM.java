package xml;

import jdk.nashorn.internal.runtime.regexp.joni.constants.NodeType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by User on 27.09.2018.
 */
public class ParserDOM {
    public static void main(String[] args) {
        try {
            File inputFile = new File(args[0]);
            File outputFile = new File(args[1]);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            NodeList students = doc.getElementsByTagName("student");
            for (int i = 0; i < students.getLength(); i++) {
                Node student = students.item(i);
                System.out.println("\nCurrent Element :" + student.getNodeName() + " has Child " + student.hasChildNodes());
                Element elementStudent = (Element) student;
                if (elementStudent != null && student.hasChildNodes()) {
                    NodeList subjects = elementStudent.getElementsByTagName("subject");
                    int sum = 0;
                    for (int j = 0; j < subjects.getLength(); j++) {
                        Element subjectElement = (Element) subjects.item(j);
                        sum += Integer.parseInt(subjectElement.getAttribute("mark"));
                        System.out.println("SubjectElement title " + subjectElement.getAttribute("title") + " mark " + subjectElement.getAttribute("mark"));
                    }
                    double average = (double) sum/subjects.getLength();
                    NodeList elementAverages = elementStudent.getElementsByTagName("average");
                    for (int j = 0; j <= elementAverages.getLength(); j++) {
                        Node elementAverage = elementAverages.item(j);
                        if (elementAverage != null) {
                            System.out.println("Average " + elementAverage.getTextContent() + " actual " + average);
                            if (Double.parseDouble(elementAverage.getTextContent()) != average) {
                                elementAverage.setTextContent(String.valueOf(average));
                            }
                        } else {
                            /*Почему после создания элемента Average увеличевается длина NodeList?*/
                            elementAverage = elementStudent.appendChild(doc.createElement("average"));
                            elementAverage.setTextContent(String.valueOf(average));
                            break;
                        }
                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
