package ru.job4j.easystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list = new ArrayList<>();

    public static EasyStream of(List<Integer> source) {
        EasyStream es = new EasyStream();
        es.list = source;
        return es;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        EasyStream es = new EasyStream();
        for (int i : list) {
            es.list.add(fun.apply(i));
        }
        return es;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        EasyStream es = new EasyStream();
        for (int i : list) {
            if (fun.test(i)) {
                es.list.add(i);
            }
        }
        return es;
    }

    public List<Integer> collect() {
        return this.list;
    }
}
