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
        return age >= 0;
    }

    public boolean hasResidencePlace() {
        return getResidencePlace() != null && !getResidencePlace().isEmpty();
    }

    public void setResidencePlace(String residencePlace) {
        this.residencePlace = residencePlace;
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.surname = this.surname;
        builder.residencePlace = this.residencePlace;
        return builder;
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

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, residencePlace);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person{ " + "name = ").append(name)
                .append(", surname = ").append(surname);
        if (this.hasAge() && this.hasResidencePlace()) {
            builder.append(", age = ").append(age).append(", residencePlace = ")
                    .append(residencePlace).append('}');
            return builder.toString();
        }

        if (this.hasAge()) {
            builder.append(", age = ").append(age).append('}');
            return builder.toString();
        }

        if (this.hasResidencePlace()) {
            builder.append(", residencePlace = ").append(residencePlace).append('}');
            return builder.toString();
        }
        builder.append("}");
        return builder.toString();
    }
}

