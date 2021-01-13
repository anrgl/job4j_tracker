package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store store = new SqlTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, store, actions);
        assertThat(store.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Store store = new SqlTracker();
        Item item = store.add(new Item("Replaced item"));
        String id = Integer.toString(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", id, replacedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, store, actions);
        assertThat(store.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Store store = new SqlTracker();
        Item item = store.add(new Item("Deleted item"));
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, store, actions);
        assertThat(store.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0"}
        );
        Store store = new SqlTracker();
        List<UserAction> actions = Collections.singletonList(
                new ExitAction()
        );
        new StartUI(output).init(input, store, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"1"}
        );
        Store store = new SqlTracker();
        List<UserAction> actions = Arrays.asList(
                new ShowAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, store, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"1"}
        );
        Store store = new SqlTracker();
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, store, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"1"}
        );
        Store store = new SqlTracker();
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, store, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-42", "0"}
        );
        Store store = new SqlTracker();
        List<UserAction> actions = Collections.singletonList(
                new ExitAction()
        );
        new StartUI(out).init(in, store, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}