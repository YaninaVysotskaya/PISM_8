package laba8.gr074001.vysotskaya;

import laba8.gr074001.vysotskaya.string_array.*;

public class Main {
    public static void main(String[] args) {
        StaticStringArray stringArray = new StaticStringArray(3);

        stringArray.add("asd");
        stringArray.add("asdf");
        stringArray.add("asdfg");
        stringArray.add("asdfgh");
        stringArray.add("asdfghT");

        stringArray.print();
    }
}