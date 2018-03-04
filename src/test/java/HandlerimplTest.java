import entities.Person;
import implementation.Handlerimpl;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HandlerimplTest {
    Handlerimpl h;
    String path = System.getProperty("user.dir")+"/src/test/resources/datasetjunit5test.csv";
    ArrayList<Person> unsortedList;
    Object[] lines;

    @BeforeAll
    void setUpData(){
        //Read everyting from file saving to array

        BufferedReader br;
        lines = null;
        try{
            br = new BufferedReader(new FileReader(path));
            lines = br.lines().toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void setUp(){
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

    @AfterEach
    void tearDown(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(path));
            for (Object line : lines) {
                pw.println((String) line);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    @Test
    @DisplayName("Get specific person")
    void testGetPerson() {
        assertEquals(h.getPerson(unsortedList.get(0)), unsortedList.get(0));
    };

    @Test
    @DisplayName("Updates a person")
    void testUpdatePerson() {
        Person initailPerson = new Person("Test", "testing", 50 , "70070070", "Glostrupvej", "Glostrup", "Looser", 80000);
        Person updatedPerson = new Person("Mike", "Timsen", 40 , "60606060", "Glostrupvej", "Glostrup", "Looser", 30000);
        h.createPerson(initailPerson);
        h.updatePerson(initailPerson, updatedPerson);
        assertEquals(updatedPerson, h.getPerson(updatedPerson));
        assertTrue(!h.getAllPersons().contains(initailPerson));
    };

    @Test
    @DisplayName("Removes a person")
    void testRemovePerson() {
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
    @DisplayName("Creates a person")
    void testCreatePerson() {
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
    @DisplayName("Find all persons in the file with colume first with a specified value")
    void testGetByFirst() {
        ArrayList<Person> firstList = h.getByAttribute("first", "Cirkeline");
        assertEquals(firstList.get(0).toString(), unsortedList.get(0).toString());
        assertTrue(firstList.size() == 1);
    };

    @Test
    @DisplayName("Find all persons in the file with colume last with a specified value")
    void testGetByLast() {
        ArrayList<Person> lastList = h.getByAttribute("last", "Madsen");
        assertEquals(lastList.get(0), unsortedList.get(0));
        assertEquals(lastList.get(1), unsortedList.get(3));
        assertTrue(lastList.size() == 2);
    }

    @Test
    @DisplayName("Find all persons in the file with colume age with a specified value")
    void testGetByAge() {
        ArrayList<Person> ageList = h.getByAttribute("age", "33");
        assertEquals(ageList.get(0), unsortedList.get(2));
        assertTrue(ageList.size() == 1);
    }

    @Test
    @DisplayName("Find all persons in the file with colume phone with a specified value")
    void testGetByPhone(){
        ArrayList<Person> phoneList = h.getByAttribute("phone", "23232323");
        assertEquals(phoneList.get(0), unsortedList.get(3));
        assertTrue(phoneList.size() == 1);
    }

    @Test
    @DisplayName("Find all persons in the file with colume street with a specified value")
    void testGetByStreet(){
        ArrayList<Person> streetList = h.getByAttribute("street", "Dragørvej");
        assertEquals(streetList.get(0), unsortedList.get(2));
        assertTrue(streetList.size() == 1);
    }

    @Test
    @DisplayName("Find all persons in the file with colume city with a specified value")
    void testGetByCity() {
        ArrayList<Person> cityList = h.getByAttribute("city", "Glostrup");
        assertEquals(cityList.get(0), unsortedList.get(0));
        assertTrue(cityList.size() == 1);
    }

    @Test
    @DisplayName("Find all persons in the file with colume word with a specified value")
    void testGetByWord(){
        ArrayList<Person> wordList = h.getByAttribute("word", "Cool");
        assertEquals(wordList.get(0), unsortedList.get(1));
        assertTrue(wordList.size() == 1);
    }

    @Test
    @DisplayName("Find all persons in the file with colume amount with a specified value")
    void testGetByAmount() {
        ArrayList<Person> amountList = h.getByAttribute("amount", "10000");
        assertEquals(amountList.get(0), unsortedList.get(3));
        assertTrue(amountList.size() == 1);
    }

    @Test
    @DisplayName("Collects all the persons in the file")
    void testGetAllPersons() {
        ArrayList<Person> data = h.getAllPersons();
        assertAll("Persons",
                () -> {
                    assertNotNull(data);
                    assertAll("Specific person",
                            () -> assertEquals(unsortedList.get(0), data.get(0)),
                            () -> assertEquals(unsortedList.get(1), data.get(1)),
                            () -> assertEquals(unsortedList.get(2), data.get(2)),
                            () -> assertEquals(unsortedList.get(3), data.get(3))
                    );
        });
    };

    @Test
    @DisplayName("Sortes all the persons in the file by age")
    void testSortByAge() {
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
        assertAll("Sorted by age", () -> {
            assertNotNull(sortedAgeList);
            assertNotNull(sortedTestList);
            assertEquals(sortedAgeList.size(), sortedTestList.size());
            assertArrayEquals(sortedAgeList.toArray(), sortedTestList.toArray());
            assertAll("First person", () -> {
                assertEquals(sortedAgeList.get(0).getFirst(), sortedTestList.get(0).getFirst());
                assertEquals(sortedAgeList.get(0).getAge(), sortedTestList.get(0).getAge());
            });
            assertAll("Last person", () -> {
                assertEquals(sortedAgeList.get(3).getFirst(), sortedTestList.get(3).getFirst());
                assertEquals(sortedAgeList.get(3).getAge(), sortedTestList.get(3).getAge());
            });
        });

    };

    @Test
    @DisplayName("Sortes all the persons in the file by amount")
    void testSortByAmount() {
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
    @DisplayName("Sortes all the persons in the file by first")
    void testSortByFirstName() {
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

}
