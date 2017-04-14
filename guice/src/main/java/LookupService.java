import basics.Animal;

import java.util.Collection;

/**
 * Service to find Animals.
 * @author Created by ergouser on 05.10.16.
 */
public interface LookupService {
    /**
     * Search for all animals having a certain name.
     * @param name search term; must not be null, but may be an empty string
     * @return all {@link Animal animals} with the name specified in {@code name}; will
     * not return null
     */
    Collection<Animal> findAnimalByName(final String name);
}
