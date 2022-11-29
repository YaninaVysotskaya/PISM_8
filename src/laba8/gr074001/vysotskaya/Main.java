package laba8.gr074001.vysotskaya;

import laba8.gr074001.vysotskaya.string_array.StringArray;

public class Main {
    public static void main(String[] args) {
        StringArray stringArray = new StringArray();

        stringArray.add("first");
        stringArray.add("second");
        stringArray.add("third");

        stringArray.print();

        System.out.println("\n");

        stringArray.reverseAllStrings();
        stringArray.print();
    }
}