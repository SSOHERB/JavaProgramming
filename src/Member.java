import java.io.Serializable;

public class Member implements Serializable {
    private String email;
    private String name;
    private int birth;

    public Member(String email, String name, int birth) {
        this.email = email;
        this.name = name;
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
