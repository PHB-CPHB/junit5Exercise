package interfaces;

import entities.Person;
import java.util.ArrayList;

public interface Handler {

    public Person getPerson(Person person);

    public void updatePerson(Person person, Person updatedPerson);

    public void removePerson(Person person);

    public void createPerson(Person person);

    public ArrayList<Person> getByAttribute(String attribute, String value);

    public ArrayList<Person> getAllPersons();

    public ArrayList<Person> sortByAge(ArrayList<Person> arr);

    public ArrayList<Person> sortByAmount(ArrayList<Person> arr);

    public ArrayList<Person> sortByFirstName(ArrayList<Person> arr);
    
    public int countUnicodedCharsInFile();
}
