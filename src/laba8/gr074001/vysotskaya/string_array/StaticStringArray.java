package laba8.gr074001.vysotskaya.string_array;

public class StaticStringArray extends StringArray {
    private final int size;

    public StaticStringArray(int size) {
        super();
        this.size = size;
    }

    @Override
    public void add(String element) {
        if (this.size <= 0) return;
        if (this.stringList.size() >= size)
            this.stringList.remove(0);

        this.stringList.add(element);
    }
}