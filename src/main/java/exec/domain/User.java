package exec.domain;

/**
 * JavaBean
 */
public class User {
    private int id;
    private String name;
    private String psw;
    private int role;

    public User() {
    }

    public User(int id, String name, String psw, int role) {
        this.id = id;
        this.name = name;
        this.psw = psw;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", role=" + role +
                '}';
    }
}
