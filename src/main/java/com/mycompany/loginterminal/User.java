/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginterminal;

/**
 *
 * @author User
 */
public class User {
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    private String name;
    private String password;
    
    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
     public void setName(String name) 
     {
         this.name = name;
     }
    
     public void setPassword(String password)
     {
         this.password = password;
     }
}
