package thu;

public class Ke {
    private int id;
    private String name;

    public Ke() {
    }

    public Ke(int id, String name) {
        if (id == 1){
            id = 2;
        }else {
            id = 3;
        }
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id == 1){
            this.id = 2;
        }else {
            this.id = 3;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ke{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
