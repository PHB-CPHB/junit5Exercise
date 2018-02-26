package entities;

public class Person {
    private String first;
    private String last;
    private int age;
    private String phone;
    private String street;
    private String city;
    private String word;
    private int amount;

    public Person(String first, String last, int age, String phone, String street, String city, String word, int amount) {
        this.first = first;
        this.last = last;
        this.age = age;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.word = word;
        this.amount = amount;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  first + "," +
                last + "," +
                age + "," +
                phone + "," +
                street + "," +
                city + "," +
                word + "," +
                amount;
    }
}
