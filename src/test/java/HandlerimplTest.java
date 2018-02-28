import entities.Person;
import implementation.Handlerimpl;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class HandlerimplTest {
    Handlerimpl h;
    String path = System.getProperty("user.dir")+"/src/test/resources/datasetjunit5test.csv";
    ArrayList<Person> unsortedList;

    @BeforeEach
    public void setUp(){
        h = new Handlerimpl(path);

        unsortedList = new ArrayList<>();
        Person pp1 = new Person("Cirkeline", "Madsen", 60 , "28282828", "Glostrupvej", "Glostrup", "Looser", 30000);
        Person pp2 = new Person("Torben", "Hansen", 89 , "30303030", "Ballerupvej", "Ballerup", "Cool", 40000);
        Person pp3 = new Person("Bertil", "Olsen", 33 , "25252525", "Dragørvej", "Dragør", "Taber", 20000);
        Person pp4 = new Person("Albert", "Madsen", 10 , "23232323", "Københavnvej", "København", "Noob", 10000);
        unsortedList.add(pp1);
        unsortedList.add(pp2);
        unsortedList.add(pp3);
        unsortedList.add(pp4);

    };

    @Test
    public void testGetPerson() {

    };

    @Test
    public void testUpdatePerson() {
        Person initailPerson = unsortedList.get(0);
        Person updatedPerson = unsortedList.get(1);
        h.createPerson(initailPerson);
        h.updatePerson(initailPerson, updatedPerson);
        assertEquals(updatedPerson, h.getPerson(updatedPerson));
        assertTrue(!h.getAllPersons().contains(initailPerson));
    };

    @Test
    public void testRemovePerson() {
        Person person = new Person(
                "Test",
                "Testing",
                26,
                "818181818",
                "fuck street",
                "fuck din mor",
                "hejsa",
                10234
        );
        h.createPerson(person);
        h.removePerson(person);
        assertTrue(h.getAllPersons().size()>0);
        assertTrue(!h.getAllPersons().contains(person));

    };

    @Test
    public void testCreatePerson() {
        Person person = new Person(
                "Florent",
                "Haxha",
                23,
                "818181818",
                "fuck street",
                "fuck din far",
                "hejsa",
                10234
        );
        h.createPerson(person);
        assertEquals(person, h.getPerson(person));

    };

    @Test
    public void testGetByAttribute() {

    };

    @Test
    public void testGetAllPersons() {

    };

    @Test
    public void testSortByAge() {

        ArrayList<Person> sortedAgeList = new ArrayList<>();
        Person p1 = new Person("Albert", "Madsen", 10 , "23232323", "Københavnvej", "København", "Noob", 10000);
        Person p2 = new Person("Bertil", "Olsen", 33 , "25252525", "Dragørvej", "Dragør", "Taber", 20000);
        Person p3 = new Person("Cirkeline", "Madsen", 60 , "28282828", "Glostrupvej", "Glostrup", "Looser", 30000);
        Person p4 = new Person("Torben", "Hansen", 89 , "30303030", "Ballerupvej", "Ballerup", "Cool", 40000);
        sortedAgeList.add(p1);
        sortedAgeList.add(p2);
        sortedAgeList.add(p3);
        sortedAgeList.add(p4);

        ArrayList<Person> sortedTestList = h.sortByAge(unsortedList);

        assertArrayEquals(sortedAgeList.toArray(), sortedTestList.toArray());
        assertEquals(sortedAgeList.size(), sortedTestList.size());

    };

    @Test
    public void testSortByAmount() {
        ArrayList<Person> sortedAmountList = new ArrayList<>();
        Person p1 = new Person("Albert", "Madsen", 10 , "23232323", "Københavnvej", "København", "Noob", 10000);
        Person p2 = new Person("Bertil", "Olsen", 33 , "25252525", "Dragørvej", "Dragør", "Taber", 20000);
        Person p3 = new Person("Cirkeline", "Madsen", 60 , "28282828", "Glostrupvej", "Glostrup", "Looser", 30000);
        Person p4 = new Person("Torben", "Hansen", 89 , "30303030", "Ballerupvej", "Ballerup", "Cool", 40000);
        sortedAmountList.add(p1);
        sortedAmountList.add(p2);
        sortedAmountList.add(p3);
        sortedAmountList.add(p4);

        ArrayList<Person> sortedTestList = h.sortByAmount(unsortedList);

        assertArrayEquals(sortedAmountList.toArray(), sortedTestList.toArray());
        assertEquals(sortedAmountList.size(), sortedTestList.size());
    }

    @Test
    public void testSortByFirstName() {
        ArrayList<Person> sortedFirstList = new ArrayList<>();
        Person p1 = new Person("Albert", "Madsen", 10 , "23232323", "Københavnvej", "København", "Noob", 10000);
        Person p2 = new Person("Bertil", "Olsen", 33 , "25252525", "Dragørvej", "Dragør", "Taber", 20000);
        Person p3 = new Person("Cirkeline", "Madsen", 60 , "28282828", "Glostrupvej", "Glostrup", "Looser", 30000);
        Person p4 = new Person("Torben", "Hansen", 89 , "30303030", "Ballerupvej", "Ballerup", "Cool", 40000);
        sortedFirstList.add(p1);
        sortedFirstList.add(p2);
        sortedFirstList.add(p3);
        sortedFirstList.add(p4);

        ArrayList<Person> sortedTestList = h.sortByFirstName(unsortedList);

        assertArrayEquals(sortedFirstList.toArray(), sortedTestList.toArray());
        assertEquals(sortedFirstList.size(), sortedTestList.size());

    };


    @Test
    public String testReadFile() {
        return null;
    };


}
