import entities.Person;
import implementation.Handlerimpl;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class HandlerimplTest {
    Handlerimpl h;
    String path;

    @BeforeEach
    public void setUp(){
        h = new Handlerimpl();
        path = System.getProperty("user.dir")+"/src/main/resources/dataset/datasetjunit5ex.csv";
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
    public void testGetPerson() {

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
        h.removePerson(updatedPerson);
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
        h.sortByAge();
    };

    @Test
    public void testSortByAmount() {

    };

    @Test
    public void testSortByFirstName() {

    };

    @Test
    public String testReadFile() {
        return null;
    };


}
