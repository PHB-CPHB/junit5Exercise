package implementation;

import entities.Person;
import interfaces.Handler;
import java.io.*;
import java.util.ArrayList;

public class Handlerimpl implements Handler {
    String path = System.getProperty("user.dir")+"/src/main/resources/dataset/datasetjunit5ex.csv";

    public Person getPerson(Person person) {
        ArrayList<Person> persons = getAllPersons(path);
        Person tmpPerson = null;
        for (int i = 0; i < persons.size(); i++){
            if(person == persons.get(i)){
                tmpPerson = persons.get(i);
            }
        }
        return tmpPerson;
    }

    public void updatePerson(Person person, Person updatedPerson) {

    }

    public void removePerson(Person person) {

    }

    public void createPerson(Person person) {
        File file = new File(path);
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(file));
            bw.append(person.toString());
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> getByAttribute(String attribute, String value) {
        return null;
    }

    public ArrayList<Person> getAllPersons(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ArrayList<Person> persons = new ArrayList();
        try {
            fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String csvLine;
            while((csvLine = reader.readLine()) != null){
                String[] row = csvLine.split(",");
                Person person = new Person(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4], row[5], row[6], Integer.parseInt(row[7]));
                persons.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return persons;
        }
    }

    public ArrayList<Person> sortByAge() {
        return null;
    }

    public ArrayList<Person> sortByAmount() {
        return null;
    }

    public ArrayList<Person> sortByName() {
        return null;
    }

    private void writeToFile(File file, Person person) {

    }
}
