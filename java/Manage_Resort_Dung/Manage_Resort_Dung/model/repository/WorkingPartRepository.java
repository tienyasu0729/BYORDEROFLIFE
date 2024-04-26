package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entity.WorkingParts;

public class WorkingPartRepository {
    ArrayList<WorkingParts> WorkingParts=new ArrayList<>();
    public ArrayList<WorkingParts> getAllWorkingParts() throws Exception{
        FileReader fr= new FileReader("D://Hoc_them/resort/database/WorkingParts.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int id=Integer.parseInt(result.split(",")[0]);
            String WorkingPartsName=result.split(",")[1];
            WorkingParts WorkingParts1=new WorkingParts(id, WorkingPartsName);
            WorkingParts.add(WorkingParts1);
        }
        br.close();
        fr.close();
        return WorkingParts;
    }

    public WorkingParts getWorkingPartsById(int id)throws Exception{
        for (WorkingParts WorkingParts : getAllWorkingParts()) {
            if(WorkingParts.getId()==id){
                return WorkingParts;
            }
        }
        return null;
    }
}
