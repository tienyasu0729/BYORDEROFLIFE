package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entity.Role;

public class RoleRepository {
    ArrayList<Role> Roles=new ArrayList<>();
    public ArrayList<Role> getAllRoles() throws Exception{
        FileReader fr= new FileReader("D://Hoc_them/resort/database/Role.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int id=Integer.parseInt(result.split(",")[0]);
            String roleName=result.split(",")[1];
            Role role=new Role(id, roleName);
            Roles.add(role);
        }
        br.close();
        fr.close();
        return Roles;
    }

    public Role getRoleById(int id)throws Exception{
        for (Role role : getAllRoles()) {
            if(role.getId()==id){
                return role;
            }
        }
        return null;
    }
}
