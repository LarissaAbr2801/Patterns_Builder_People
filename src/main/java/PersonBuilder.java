public class PersonBuilder implements IBuilder {

    protected String name;
    protected String surname;
    protected int age = -1;
    protected String residencePlace;

    @Override
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Вы ввели некорректный возраст");
        this.age = age;
        return this;
    }

    @Override
    public PersonBuilder setResidencePlace(String residencePlace) {
        this.residencePlace = residencePlace;
        return this;
    }

    @Override
    public Person build() {
        Person person = new Person(name, surname, age, residencePlace);

        if (name == null || surname == null) {
            throw new IllegalArgumentException("Вы не ввели обязательные данные!");
        }
        return person;
    }
}