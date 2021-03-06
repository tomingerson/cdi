import basics.Animal;
import basics.Cat;
import basics.Dog;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the same class as in the mocktests example. We will change the SomeAction here instead.
 *
 * @author Created by ergouser on 05.10.16.
 */
@com.google.inject.Singleton
public class LookupServiceImpl implements LookupService {

    private final static Collection<Animal> animals = List.of(new Dog("molly"), new Cat("poppy"), new Cat("molly"));

    /**
     * takes the given name and searches for all known animals with that name
     *
     * @param name name of the animal
     * @return all animals found with the {@code name}
     */
    public final Collection<Animal> findAnimalByName(final String name) {
        if (StringUtils.isNotEmpty(name)) {
            return animals.stream()
                    .filter(a -> name.equalsIgnoreCase(a.getName()))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return Collections.emptyList();
    }
}
