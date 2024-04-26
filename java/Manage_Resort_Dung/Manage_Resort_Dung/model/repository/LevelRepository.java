package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entity.Level;

public class LevelRepository {
    ArrayList<Level> Levels=new ArrayList<>();
    public ArrayList<Level> getAllLevels() throws Exception{
        FileReader fr= new FileReader("D://Hoc_them/resort/database/Level.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int id=Integer.parseInt(result.split(",")[0]);
            String levelName=result.split(",")[1];
            Level level=new Level(id, levelName);
            Levels.add(level);
        }
        br.close();
        fr.close();
        return Levels;
    }

    public Level getLevelById(int id)throws Exception{
        for (Level level : getAllLevels()) {
            if(level.getId()==id){
                return level;
            }
        }
        return null;
    }
}
