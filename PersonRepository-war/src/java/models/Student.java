/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author asheshpatel
 */
@Entity
@DiscriminatorValue(value = "Student")
public class Student extends Person{
   

    public Student(Long id, String name, String address, String phone, String email) {
        super(id, name, address, phone, email);
    }

    public Student() {
       
    }

    @Override
    public String toString() {
        return "Student:" +super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

   

    

    
    


    
}
