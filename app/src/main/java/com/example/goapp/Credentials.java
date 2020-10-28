package com.example.goapp;

public class Credentials {
    private String Username;
    private String Password;


    Credentials(String registeredname, String registeredPassword){
        this.Username = registeredname;
        this.Password = registeredPassword;

    }

    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String username)
    {
        Username = username;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String password)
    {
        Password = password;
    }

}
