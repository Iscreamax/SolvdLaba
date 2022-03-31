package iphone;

public class Client {
    private String firstName;
    private String surname;
    private String patronymic;
    private int age;
    public final String id;


    public Client(String firstName, String surname, String patronymic, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        id = createID();
    }


    public Client(String firstName, String surname, String patronymic) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        id = createID();
    }


    public Client(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
        id = createID();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    public String createID() {
        String result = "";
        for (int i = 0; i < 15; i++) {
            String j;
            j = Integer.toString((int) (Math.random() * 10));
            result = result + j;
        }
        return result;
    }
}
