package ru.job4j.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles;

    @Before
    public void setUp() {
        profiles = List.of(
                new Profile(new Address("Moscow", "Lenin st.", 1, 1)),
                new Profile(new Address("Moscow", "Lenin st.", 1, 1)),
                new Profile(new Address("Moscow", "Lenin st.", 1, 1)),
                new Profile(new Address("Moscow", "Lenin st.", 1, 42)),
                new Profile(new Address("Moscow", "Lenin st.", 1, 42))
        );
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