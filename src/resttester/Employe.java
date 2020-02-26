/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resttester;

/**
 *
 * @author informatica
 */
class Employe {
    public String employeId;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;

    public Employe(String employeId, String firstName, String lastName, String email, String phone) {
        this.employeId = employeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        
    }

    @Override
    public String toString() {
        return "{" + "\"employeeId\":" + employeId + ", \"firstName\":\"" +firstName + "\", \"lastName\":\"" + lastName + "\", \"email\":\"" + email + "\", \"phone\":\"" + phone + "\"}";
    }
    
    
}
