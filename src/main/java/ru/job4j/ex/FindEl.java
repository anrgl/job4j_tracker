package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element \"" + key + "\" not found.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] value = {"Hello", "World", "!"};
            int index = indexOf(value, "Java");
            System.out.println(index);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
