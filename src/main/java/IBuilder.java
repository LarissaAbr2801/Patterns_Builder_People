public interface IBuilder {

    IBuilder setName(String name);
    IBuilder setSurname(String surname);
    IBuilder setAge(int age);
    IBuilder setResidencePlace(String residencePlace);
    Person build();
}
