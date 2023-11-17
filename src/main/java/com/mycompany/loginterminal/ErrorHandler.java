/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginterminal;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class ErrorHandler {
    private int option;

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    private String Name;
    private String Password;
    
    static boolean processUser(String Nama, String Password){
        if (Nama == null || Password == null)
            throw new IllegalArgumentException("Invalid option");
        else {
        return true;
        }
    }
       
    
    static String processOption(int option){
        switch (option) {
            case 1:
                System.out.println("--Opsi Login Terpilih--");
                break;
            case 2:
                System.out.println("--Opsi Registrasi Terpilih--");
                break;
            default:
                throw new IllegalArgumentException("Invalid option");
        }
        return null;
    }
}
