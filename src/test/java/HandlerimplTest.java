import entities.Person;
import implementation.Handlerimpl;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class HandlerimplTest {
    Handlerimpl h;
    String path;
    ArrayList<Person> sortedList;
    ArrayList<Person> unsortedList;

    @BeforeEach
    public void setUp(){
        h = new Handlerimpl();
        path = System.getProperty("user.dir")+"/src/main/resources/dataset/datasetjunit5ex.csv";
        sortedList = new ArrayList<>();
        Person p1 = new Person("person1", "person2", 10 , "5819348192", "soajda", "aworjo", "hejsas", 1023);
        Person p2 = new Person("person2", "person3", 11 , "5819348192", "soajda", "aworjo", "hejsas", 1033);
        Person p3 = new Person("person3", "person4", 12 , "5819348192", "soajda", "aworjo", "hejsas", 1043);
        Person p4 = new Person("person4", "person5", 13 , "5819348192", "soajda", "aworjo", "hejsas", 1053);
        sortedList.add(p1);
        sortedList.add(p2);
        sortedList.add(p3);
        sortedList.add(p4);

        unsortedList = new ArrayList<>();
        Person pp1 = new Person("person4", "person5", 13 , "5819348192", "soajda", "aworjo", "hejsas", 1053);
        Person pp2 = new Person("person3", "person4", 12 , "5819348192", "soajda", "aworjo", "hejsas", 1043);
        Person pp3 = new Person("person1", "person2", 10 , "5819348192", "soajda", "aworjo", "hejsas", 1023);
        Person pp4 = new Person("person2", "person3", 11 , "5819348192", "soajda", "aworjo", "hejsas", 1033);
        unsortedList.add(pp1);
        unsortedList.add(pp2);
        unsortedList.add(pp3);
        unsortedList.add(pp4);
    };
/*
    @BeforeAll
    public void initializeResources(){
        File dir = new File (System.getProperty("user.dir") + "/src/main/resources/dataset/");
        File file = new File(System.getProperty("user.dir")+"/src/main/resources/dataset/datasetjunit5ex.csv");
        try {
             File.createTempFile("temp",".csv", dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public void tearDown(){
    }
*/

    @Test
    public Person testGetPerson() {
        return null;
    };

    @Test
    public void testUpdatePerson() {
        Person initailPerson = new Person(
                "Florent",
                "Haxha",
                23,
                "818181818",
                "fuck street",
                "fuck din mor",
                "hejsa",
                10234
        );
        Person updatedPerson = new Person(
                "Mikkel",
                "Vetter",
                50,
                "818181818",
                "fuck street",
                "fuck din mor",
                "hejsa",
                10234
        );
        h.createPerson(initailPerson);
        h.updatePerson(initailPerson, updatedPerson);
        assertEquals(updatedPerson, h.getPerson(updatedPerson));
        assertTrue(!h.getAllPersons(path).contains(initailPerson));
    };

    @Test
    public void testRemovePerson() {
        Person person = new Person(
                "Florent",
                "Haxha",
                23,
                "818181818",
                "fuck street",
                "fuck din mor",
                "hejsa",
                10234
        );
        h.removePerson(person);
        assertTrue(h.getAllPersons(path).size()>0);
        assertTrue(!h.getAllPersons(path).contains(person));

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
        ArrayList<Person> sortedTestList = h.sortByAge(unsortedList);

        assertArrayEquals(sortedList.toArray(), sortedTestList.toArray());
        assertEquals(sortedList.size(), sortedTestList.size());

    };

    @Test
    public void testSortByAmount() {

        ArrayList<Person> sortedTestList = h.sortByAmount(unsortedList);

        assertArrayEquals(sortedList.toArray(), sortedTestList.toArray());
        assertEquals(sortedList.size(), sortedTestList.size());
    }

    @Test
    public void testSortByFirstName() {
        ArrayList<Person> sortedTestList = h.sortByFirstName(unsortedList);

        assertArrayEquals(sortedList.toArray(), sortedTestList.toArray());
        assertEquals(sortedList.size(), sortedTestList.size());

    };


    @Test
    public String testReadFile() {
        return null;
    };


}
