import basics.Animal;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author Created by ergouser on 05.10.16.
 */
public class AnimalService {

    private final LookupService lookupService;

    @com.google.inject.Inject
    public AnimalService(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    /**
     * takes care of all the known animals with the given name.
     *
     * @param name the animal-identifier
     * @return all animals taken care of
     */
    public Collection<Animal> takeCareOfAnimal(final String name) {
        return lookupService.findAnimalByName(name)
                .stream()
                .peek(animal -> System.out.println("Taking care of " + animal.getClass().getSimpleName() + " " + animal.getName()))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
