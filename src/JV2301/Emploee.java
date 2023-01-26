package JV2301;

import java.util.UUID;

public class Emploee {
    private String id;
    //position. salary.
    private String name;
    private String position;
    private Integer salary;

    public Emploee(String name, String position, Integer salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.id= UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id "+id.substring(8)+'\''+
                "name='" + name +  +'\''+
                "--position='" + position + '\'' +
                "-- salary=" + salary;
    }
}
