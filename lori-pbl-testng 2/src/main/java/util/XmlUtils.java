package util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XmlUtils {
    private Document doc;
    public XmlUtils(){
    }
    public XmlUtils(File xmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    public String getData(String xpath_input){
        System.out.println("xpath"+ xpath_input);
        XPath xpath = XPathFactory.newInstance().newXPath();
        try {
            NodeList nodes = (NodeList)xpath.evaluate(xpath_input, this.doc, XPathConstants.NODESET);
            if (nodes.getLength()==0) {
                System.out.println(Thread.currentThread().getName() + ":XPATH -> " + xpath_input + " not available in current document");
                return "";
            }else{
                return nodes.item(0).getTextContent();
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return "";
        }

    }

}
