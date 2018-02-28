package entities;

public class Person implements Comparable<Person> {
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

    public int compareTo(Person o) {
        if(this.getAge() > o.getAge()){
            return 1;
        } else if(this.getAge() < o.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (amount != person.amount) return false;
        if (first != null ? !first.equals(person.first) : person.first != null) return false;
        if (last != null ? !last.equals(person.last) : person.last != null) return false;
        if (phone != null ? !phone.equals(person.phone) : person.phone != null) return false;
        if (street != null ? !street.equals(person.street) : person.street != null) return false;
        if (city != null ? !city.equals(person.city) : person.city != null) return false;
        return word != null ? word.equals(person.word) : person.word == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }
}
