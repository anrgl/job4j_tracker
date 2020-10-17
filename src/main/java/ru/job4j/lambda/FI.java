package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = new Attachment[] {
                new Attachment("image 1", 20),
                new Attachment("image 2", 120),
                new Attachment("image 3", 10)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        Comparator<Attachment> comparator1 = (left, right) -> {
            return left.getSize() - right.getSize();
        };
        Comparator<String> cmpSize = (left, right) -> left.length() - right.length();

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDecsSize = (left, right) -> right.length() - left.length();

        Arrays.sort(atts, comparator);
        Arrays.sort(atts, comparator1);
    }
}
