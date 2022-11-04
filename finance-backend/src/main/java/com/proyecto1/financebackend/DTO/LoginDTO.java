package com.proyecto1.financebackend.DTO;

/**
 * It's a simple DTO that contains two fields: email and password
 */
public class LoginDTO {
    // Class atributes: email and password
    String email;
    String password;

    // Constructor that receives two parameters: email and password.
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * This function returns the email of the user
     * 
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This function sets the email of the user
     * 
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This function returns the password of the user
     * 
     * @return The password
     */
    public String getPassword() {
        return password;
    }

   /**
    * This function sets the password of the user
    * 
    * @param password The password to use for the connection.
    */
    public void setPassword(String password) {
        this.password = password;
    }
}
