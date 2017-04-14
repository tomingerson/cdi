package basics;

/**
 * Representation of an Animal <i>dog.</i>
 */
public class Dog implements Animal {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void talk() {
        System.out.println("Woof");
    }

    @Override
    public String getName() {
        return name;
    }
}
