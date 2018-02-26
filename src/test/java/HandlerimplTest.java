import entities.Person;
import implementation.Handlerimpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;



public class HandlerimplTest {
    Handlerimpl h;
    String path;

    @BeforeEach
    public void setUp(){
        h = new Handlerimpl();
        path = System.getProperty("user.dir")+"/src/main/resources/dataset/datasetjunit5ex.csv";
    }
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
    }

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
    }

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

    }

    @Test
    public void testCreatePerson() {
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
        h.createPerson(person);
        assertEquals(person, h.getPerson(person));

    }

    @Test
    public ArrayList<Person> testGetByAttribute() {
        return null;
    }

    @Test
    public ArrayList<Person> testGetAllPersons() {
        return null;
    }

    @Test
    public ArrayList<Person> testSortByAge() {
        return null;
    }

    @Test
    public ArrayList<Person> testSortByAmount() {
        return null;
    }

    @Test
    public ArrayList<Person> testSortByName() {
        return null;
    }

    @Test
    public String testReadFile() {
        return null;
    }
}
