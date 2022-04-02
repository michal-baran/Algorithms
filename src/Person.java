import java.util.Arrays;

public class Person {
    String name;
    Person[] friends = new Person[]{};

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person[] friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public Person[] getFriends() {
        return friends;
    }

    public boolean isSeller() {
        return name.toLowerCase().charAt(name.length() - 1) == 'm';
    }
}
