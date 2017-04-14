package basics;

/**
 * Describes an animal.
 *
 * @author Created by tom on 02.10.2016.
 */
public interface Animal {
    /**
     * sound the animal makes
     */
    void talk();

    /**
     * @return the name of this animal
     */
    String getName();
}
