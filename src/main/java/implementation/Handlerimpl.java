package implementation;

import entities.Person;
import interfaces.Handler;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

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

            File inFile = new File(path);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(path));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(person.toString())) {

                    pw.println(line);
                    pw.flush();
                } else if (line.trim().equals(person.toString())) {
                    pw.println(updatedPerson.toString());
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void removePerson(Person person) {
        try {

            File inFile = new File(path);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(path));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(person.toString())) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
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

    public ArrayList<Person> sortByAge(ArrayList<Person> arr) {

        arr.sort(Comparator.comparing(Person::getAge));

        return arr;
    }

    public ArrayList<Person> sortByAmount(ArrayList<Person> arr) {

        arr.sort(Comparator.comparing(Person::getAmount));

        return arr;
    }

    public ArrayList<Person> sortByFirstName(ArrayList<Person> arr) {

        arr.sort(Comparator.comparing(Person::getFirst));

        return arr;
    }

}
