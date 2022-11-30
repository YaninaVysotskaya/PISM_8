package laba8.gr074001.vysotskaya;

import laba8.gr074001.vysotskaya.string_array.StringArray;

public class Main {
    public static void main(String[] args) {
        StringArray stringArray = new StringArray();

        stringArray.add("asd");
        stringArray.add("asdf");
        stringArray.add("asdfg");
        stringArray.add("asdfgh");

        stringArray.printStringsLength();
    }
}