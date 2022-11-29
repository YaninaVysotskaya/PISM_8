package laba8.gr074001.vysotskaya.string_array;

import java.util.ArrayList;

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
}