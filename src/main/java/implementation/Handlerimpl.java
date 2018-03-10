package implementation;

import entities.Person;
import interfaces.Handler;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handlerimpl implements Handler {


    public Person getPerson(Person person, ArrayList<Person> persons) {
        Person tmpPerson = null;
        for (Person currentPerson: persons) {
            if(currentPerson.toString().equals(person.toString())){
                tmpPerson = person;
            }
        }
        return tmpPerson;
    }

    public ArrayList<Person> updatePerson(Person person, Person updatedPerson, String path) {
        ArrayList<Person> errorList = new ArrayList<>();
        try {

            File inFile = new File(path);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return errorList;
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
                return errorList;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return getAllPersons(path);
        }
    }

    public ArrayList<Person> removePerson(Person person, String path) {
        ArrayList<Person> errorList = new ArrayList<>();
        BufferedReader br = null;
        PrintWriter pw = null;
        try {

            File inFile = new File(path);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return errorList;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            br = new BufferedReader(new FileReader(path));
            pw = new PrintWriter(new FileWriter(tempFile));

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
                return errorList;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return getAllPersons(path);
        }
    }

    public ArrayList<Person> createPerson(Person person, String path) {
        File file = new File(path);
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile(file, "rw");
            raf.seek(file.length());
            raf.write(person.toString().getBytes());
            raf.writeBytes(System.getProperty("line.separator"));
            raf.close();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            return getAllPersons(path);
        }
    }

    public ArrayList<Person> getByAttribute(String attribute, String value, String path) {
        ArrayList<Person> attributeList = new ArrayList<>();
        ArrayList<Person> persons = getAllPersons(path);
        switch (attribute){
            case "first":
                for (Person person: persons) {
                    if(person.getFirst().equals(value)){
                        attributeList.add(person);
                    }
                }
                break;
            case "last":
                for (Person person: persons) {
                    if(person.getLast().equals(value)){
                        attributeList.add(person);
                    }
                }
                break;
            case "age":
                for (Person person: persons) {
                    if(person.getAge() == Integer.parseInt(value)){
                        attributeList.add(person);
                    }
                }
                break;
            case "phone":
                for (Person person: persons) {
                    if(person.getPhone().equals(value)){
                        attributeList.add(person);
                    }
                }
                break;
            case "street":
                for (Person person: persons) {
                    if(person.getStreet().equals(value)){
                        attributeList.add(person);
                    }
                }
                break;
            case "city":
                for (Person person: persons) {
                    if(person.getCity().equals(value)){
                        attributeList.add(person);
                    }
                }
                break;
            case "word":
                for (Person person: persons) {
                    if(person.getWord().equals(value)){
                        attributeList.add(person);
                    }
                }
                break;
            case "amount":
                for (Person person: persons) {
                    if(person.getAmount() == Integer.parseInt(value)){
                        attributeList.add(person);
                    }
                }
                break;
        }
        return attributeList;

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

    @Override
    public int countUnicodedCharsInFile(String path) {
        int chars = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((br.readLine() != null)){
                chars += br.readLine().length();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Handlerimpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return chars;
    }
}
