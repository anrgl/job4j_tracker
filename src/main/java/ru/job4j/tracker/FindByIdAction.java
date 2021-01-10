package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = store.findById(id);
        if (item != null) {
            out.println(item.getName());
        } else {
            out.println("Item with " + id + " id not found!");
        }
        return true;
    }
}
