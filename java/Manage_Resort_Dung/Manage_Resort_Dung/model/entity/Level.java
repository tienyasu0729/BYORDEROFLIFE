package model.entity;

public class Level {
    private int id;
    private String levelName;
    public Level(int id, String levelName) {
        this.id=id;
        this.levelName = levelName;
    }
    public String getLevelName() {
        return levelName;
    }
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Level [id=" + id + ", levelName=" + levelName + "]";
    }
}
