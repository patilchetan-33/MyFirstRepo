package com.qa.makeMyrTrip.util;


import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLUtils {

        // Load XML Document
        private static Document loadXML(String filePath) throws Exception {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            return doc;
        }

        // Save XML Document
        private static void saveXML(Document doc, String filePath) throws Exception {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        }

        // ------------------------------------------------------------
        // 🔹 1. UPDATE MULTIPLE ATTRIBUTES
        // ------------------------------------------------------------
        public static void updateAttributes(String filePath, String tagName,
                                            String[][] attributes) throws Exception {

            Document doc = loadXML(filePath);
            NodeList nodes = doc.getElementsByTagName(tagName);

            for (int i = 0; i < nodes.getLength(); i++) {
                Element elem = (Element) nodes.item(i);

                for (String[] attribute : attributes) {
                    elem.setAttribute(attribute[0], attribute[1]);  // name, value
                }
            }

            saveXML(doc, filePath);
        }

        // ------------------------------------------------------------
        // 🔹 2. UPDATE NESTED NODES (e.g., parent->child->child)
        // ------------------------------------------------------------
        public static void updateNestedNode(String filePath, String[] tagPath,
                                            String attributeName, String newValue) throws Exception {

            Document doc = loadXML(filePath);
            Element currentElement = doc.getDocumentElement();

            for (String tag : tagPath) {
                NodeList list = currentElement.getElementsByTagName(tag);
                currentElement = (Element) list.item(0); // drill down
            }

            currentElement.setAttribute(attributeName, newValue);
            saveXML(doc, filePath);
        }

        // ------------------------------------------------------------
        // 🔹 3. UPDATE BASED ON VALUE MATCH
        // ------------------------------------------------------------
        public static void updateNodeByValue(String filePath, String tagName,
                                             String attrNameToMatch, String valueToMatch,
                                             String attrToUpdate, String newValue) throws Exception {

            Document doc = loadXML(filePath);
            NodeList nodes = doc.getElementsByTagName(tagName);

            for (int i = 0; i < nodes.getLength(); i++) {
                Element elem = (Element) nodes.item(i);

                if (elem.hasAttribute(attrNameToMatch) &&
                        elem.getAttribute(attrNameToMatch).equals(valueToMatch)) {
                    elem.setAttribute(attrToUpdate, newValue);
                }
            }

            saveXML(doc, filePath);
        }

        // ------------------------------------------------------------
        // 🔹 4. READ VALUE FROM XML (return as String)
        // ------------------------------------------------------------
        public static String readValue(String filePath, String tagName, String attributeName) throws Exception {
            Document doc = loadXML(filePath);
            NodeList nodes = doc.getElementsByTagName(tagName);

            if (nodes.getLength() > 0) {
                Element elem = (Element) nodes.item(0);
                return elem.getAttribute(attributeName);
            }
            return null;
        }



    }


