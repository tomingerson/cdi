import basics.Animal;
import basics.Dog;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Created by ergouser on 05.10.16.
 */
public class AnimalServiceTest {

    private Injector injector;
    private AnimalService animalService;

    @BeforeEach
    public void setUp()  {
        this.injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(LookupService.class).to(MockLookupService.class);
            }
        });
        this.animalService = injector.getInstance(AnimalService.class);
    }

    @AfterEach
    public void tearDown()  {
        this.animalService = null;
        this.injector = null;
    }

    @Test
    public void takeCareOfAnimal()  {
        Collection<Animal> animals = this.animalService.takeCareOfAnimal("molly");
        assertThat("there should be one Dog", animals, is(CoreMatchers.notNullValue()));
        assertThat("wrong animal", animals.iterator().next().getName(), is(CoreMatchers.equalTo("alfie")));
    }

    private static class MockLookupService implements LookupService {

        @Override
        public Collection<Animal> findAnimalByName(String name) {
            return Collections.singletonList(new Dog("alfie"));
        }
    }
}