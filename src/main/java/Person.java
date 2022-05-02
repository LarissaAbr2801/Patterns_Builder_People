import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected Integer age = null;
    protected String residencePlace;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String residencePlace) {
        this.name = name;
        this.surname = surname;
        this.residencePlace = residencePlace;
    }

    public Person(String name, String surname, int age, String residencePlace) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.residencePlace = residencePlace;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age != null) return OptionalInt.of(age);
        return OptionalInt.empty();
    }

    public String getResidencePlace() {
        return residencePlace;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasResidencePlace() {
        return getResidencePlace() != null && !getResidencePlace().isEmpty();
    }

    public void setResidencePlace(String residencePlace) {
        this.residencePlace = residencePlace;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = getAge().getAsInt();
            age++;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age)
                && Objects.equals(name, person.name)
                && Objects.equals(surname, person.surname)
                && Objects.equals(residencePlace, person.residencePlace);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.surname = this.surname;
        builder.residencePlace = this.residencePlace;
        builder.build();
        return builder;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, residencePlace);
    }

    @Override
    public String toString() {
        if (this.hasAge() && this.getAge().getAsInt() >= 0 && this.hasResidencePlace()) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", residencePlace='" + residencePlace + '\'' +
                    '}';
        }

        if (this.hasAge() && this.getAge().getAsInt() >= 0) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age + '\'' +
                    '}';
        }

        if (this.hasResidencePlace()) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", residencePlace='" + residencePlace + '\'' +
                    '}';
        }

        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';

    }
}

