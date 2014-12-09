/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Yu
 */
public class Customer extends Person{
    
    
    String workID;

    public Customer() {
        super();
        this.workID = "I'm String workID";
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }
    
    
    
}
