public class GuiceApplication {

    public static void main(String... args) {
        final com.google.inject.Injector injector =
                com.google.inject.Guice.createInjector(new GuiceModule());



        final AnimalService animalService = injector.getInstance(AnimalService.class);
        animalService.takeCareOfAnimal("molly");
    }
}
