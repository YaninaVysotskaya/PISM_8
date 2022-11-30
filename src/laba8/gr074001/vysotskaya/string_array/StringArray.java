package laba8.gr074001.vysotskaya.string_array;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class StringArray {
    private ArrayList<String> stringList;

    public StringArray() {
        this.stringList = new ArrayList<>();
    }

    public StringArray(ArrayList<String> stringList) {
        this.stringList = stringList;
    }

    public void add(String element) {
        this.stringList.add(element);
    }

    public void remove(String element) {
        this.stringList.remove(element);
    }

    public void remove(int index) {
        if (index >= 0 && index < this.stringList.size())
            this.stringList.remove(index);
    }

    public int equalsAmount(int index) {
        if (index < 0 || index >= this.stringList.size()) return 0;
        return this.equalsAmount(this.stringList.get(index));
    }

    public int equalsAmount(String string) {
        int amount = 0;
        for (String element : this.stringList) {
            if (element.equals(string)) {
                amount++;
            }
        }
        return amount;
    }

    public void print() {
        for (int i = 0; i < this.stringList.size(); i++) {
            System.out.println(i + ": " + this.stringList.get(i));
        }
    }

    public void reverseAllStrings() {
        for (int i = 0; i < this.stringList.size(); i++) {
            this.stringList.set(i, new StringBuilder(this.stringList.get(i)).reverse().toString());
        }
    }

    public void loadFromXmlFile(String filename) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("xml_files/" + filename));
            NodeList nodeList = document.getFirstChild().getChildNodes();

            this.stringList.clear();
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
                this.stringList.add(nodeList.item(i).getTextContent());
            }
        } catch (Exception ex) { System.out.println("Open parsing error: " + ex); }
    }

    public void saveToXmlFile(String filename) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element root = document.createElement("root");
            for (String stringElement : this.stringList) {
                Element xmlElement = document.createElement("element");
                xmlElement.appendChild(document.createTextNode(stringElement));
                root.appendChild(xmlElement);
            }
            document.appendChild(root);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml_files/" + filename)));
        } catch (Exception ignored) { }
    }

    public void printCharStats() {
        Map<Character, Integer> chars = new HashMap<>();
        for (String element : this.stringList) {
            for (Character charElement : element.toCharArray()) {
                if (chars.containsKey(charElement))
                    chars.put(charElement, chars.get(charElement) + 1);
                else
                    chars.put(charElement, 1);
            }
        }
        for (Character character : chars.keySet()) {
            System.out.println(character + ": " + chars.get(character));
        }
    }

    public boolean findSubstring(String substring) {
        for (String element : this.stringList) {
            if (element.contains(substring))
                return true;
        }
        return false;
    }
}