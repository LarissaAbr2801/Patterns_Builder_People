import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
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
        return OptionalInt.of(age);
    }

    public String getResidencePlace() {
        return residencePlace;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean hasAge() {
        return !getAge().isEmpty();
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
        return age == person.age
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
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", residencePlace='" + residencePlace + '\'' +
                '}';
    }
}

