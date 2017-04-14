public class SpringApplication {

    public static void main(String... args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext ctx =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext();
        ctx.register(SpringConfiguration.class);
        ctx.refresh();

        AnimalService animalService = ctx.getBean(AnimalService.class);
        animalService.takeCareOfAnimal("molly");
    }
}
