import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String userName;
    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", team=" + team +
                '}';
    }
}
