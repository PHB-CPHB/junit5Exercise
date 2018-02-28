package interfaces;

import entities.Person;
import java.util.ArrayList;

public interface Handler {

    public Person getPerson(Person person);

    public void updatePerson(Person person, Person updatedPerson);

    public void removePerson(Person person);

    public void createPerson(Person person);

    public ArrayList<Person> getByAttribute(String attribute, String value);

    public ArrayList<Person> getAllPersons(String path);

    public ArrayList<Person> sortByAge();

    public ArrayList<Person> sortByAmount();

    public ArrayList<Person> sortByFirstName();
}
