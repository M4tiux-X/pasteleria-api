package com.pasteleria.api.entidades;

public class LoginRequest {
    private String correo;
    private String pass;
    
    public LoginRequest() {
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getPass() {
        return pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
}
