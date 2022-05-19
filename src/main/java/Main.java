public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(45)
                .setResidencePlace("Сидней")
                .build();
        mom.happyBirthday();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(11)
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        try {
            // Возраст недопустимый
            new PersonBuilder().setName("").setSurname("f").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
