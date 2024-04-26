/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.text.ParseException;
import view.CompanyManagement;
import view.Menu;

/**
 *
 * @author Tienn
 */
public class Main {
     public static void main(String[] args) throws ParseException, IOException {

        Menu companyManagement = new CompanyManagement();

        companyManagement.run();

    }
}
