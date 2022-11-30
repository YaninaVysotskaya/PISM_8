package laba8.gr074001.vysotskaya;

import laba8.gr074001.vysotskaya.string_array.StringArray;

public class Main {
    public static void main(String[] args) {
        StringArray stringArray = new StringArray();

        stringArray.loadFromTxtFile("strings.txt");
        stringArray.print();
        System.out.println("_____________________");

        stringArray.add("first");
        stringArray.add("second");
        stringArray.add("third");
        stringArray.print();

        System.out.println("_____________________");
        System.out.println(stringArray.findSubstring("fir")); // true
        System.out.println(stringArray.findSubstring("firt")); // false
        System.out.println(stringArray.findSubstring("ond")); // true
        System.out.println("_____________________");

        stringArray.printCharStats();
        stringArray.saveToXmlFile("testSave.xml");

        System.out.println("_____________________");
        stringArray.reverseAllStrings();
        stringArray.print();

        System.out.println("_____________________");
        stringArray.loadFromXmlFile("testSave.xml");
        stringArray.print();
    }
}