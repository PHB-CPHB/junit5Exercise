package interfaces;

import entities.Person;
import java.util.ArrayList;

public interface Handler {

    public Person getPerson(Person person, ArrayList<Person> persons);

    public ArrayList<Person> updatePerson(Person person, Person updatedPerson, String path);

    public ArrayList<Person> removePerson(Person person, String path);

    public ArrayList<Person> createPerson(Person person, String path);

    public ArrayList<Person> getByAttribute(String attribute, String value, String path);

    public ArrayList<Person> getAllPersons(String path);

    public ArrayList<Person> sortByAge(ArrayList<Person> arr);

    public ArrayList<Person> sortByAmount(ArrayList<Person> arr);

    public ArrayList<Person> sortByFirstName(ArrayList<Person> arr);
    
    public int countUnicodedCharsInFile(String path);
}
