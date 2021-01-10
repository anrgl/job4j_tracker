package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (memTracker.delete(id)) {
            out.println("Item deleted success!");
        } else {
            out.println("Error. Something wrong!");
        }
        return true;
    }
}
