public class PersonBuilder implements IBuilder {

    protected String name;
    protected String surname;
    protected int age;
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
        Person person = new Person(name, surname);

        if (!person.hasAge() || !person.hasResidencePlace()){
            return person;
        }
        if (person.hasAge() && person.getAge().getAsInt() >= 0 && person.hasResidencePlace()) {
            return new Person(name, surname, age, residencePlace);
        }

        if (person.hasAge() && person.getAge().getAsInt() >= 0) {
            return new Person(name, surname, age);
        }

        if (person.hasResidencePlace()) {
            return new Person(name, surname, residencePlace);
        }
        throw new IllegalArgumentException("Вы ввели некорректно данные!");
    }
}