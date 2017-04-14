package basics;

/**
 * A representation of the animal <i>cat</i>.
 * @author Created by tom on 02.10.2016.
 */
public class Cat implements Animal {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void talk() {
        System.out.println("Meow");
    }

    @Override
    public String getName() {
        return name;
    }
}
