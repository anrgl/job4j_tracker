package ru.job4j.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Moscow", "Lenin st.", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "Lenin st.", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "Lenin st.", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "Lenin st.", 1, 42)));
        profiles.add(new Profile(new Address("Moscow", "Lenin st.", 1, 42)));
    }

    @Test
    public void whenAddressesRepeatThenOnlyUniqueAddresses() {
        List<Address> expect = List.of(
                new Address("Moscow", "Lenin st.", 1, 1),
                new Address("Moscow", "Lenin st.", 1, 42)
        );
        List<Address> out = Profiles.collect(profiles);
        assertThat(out, is(expect));
        assertThat(out.size(), is(expect.size()));
    }
}