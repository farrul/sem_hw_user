import java.util.Objects;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;

    public User(long id, String firstName, String lastName, int age, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof User o)) {
            return false;
        }
        return id == o.id
                && Objects.equals(firstName, o.firstName)
                && Objects.equals(lastName, o.lastName)
                && age == o.age
                && Objects.equals(nationality, o.nationality);
    }

    @Override
    public String toString() {
        return String.format("id - %s, name - %s %s, age - %d, nation - %s",
                id, firstName, lastName, age, nationality);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        result = 31 * result + nationality.hashCode();
        return result;
    }
}
