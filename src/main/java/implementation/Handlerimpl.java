package implementation;

import entities.Person;
import interfaces.Handler;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Handlerimpl implements Handler {

    private ArrayList<Person> persons;
    private String path;

    public Handlerimpl(){
        persons = getAllPersons(System.getProperty("user.dir")+"/src/main/resources/dataset/datasetjunit5ex.csv");
        path = System.getProperty("user.dir")+"/src/main/resources/dataset/datasetjunit5ex.csv";
    }

    public Person getPerson(Person person) {
        Person tmpPerson = null;
        for (Person currentPerson: persons) {
            if(currentPerson.toString().equals(person.toString())){
                tmpPerson = person;
            }
        }
        return tmpPerson;
    }

    public void updatePerson(Person person, Person updatedPerson) {
        try {
            throw new Exception("Not done yet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removePerson(Person person) {
        try {
            throw new Exception("Not done yet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createPerson(Person person) {
        File file = new File(path);
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile(file, "rw");
            raf.seek(file.length());
            raf.write(person.toString().getBytes());
            raf.writeBytes(System.getProperty("line.separator"));
            raf.close();
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
}
