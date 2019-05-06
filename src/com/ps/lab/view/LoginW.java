package com.ps.lab.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.String;

public class LoginW extends JFrame {
    private JPanel panel1;
    private JTextField textField11;
    private JPasswordField passwordField11;
    private JButton loginButton;
    private JLabel username;
    private JLabel password;

    public LoginW(){
        add(panel1);
        username.setText("Username");
        password.setText("Password");
        setTitle("Login");
        setSize(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getUsername(){
        return textField11.getText();
    }
    public String getPassword(){
        return passwordField11.getText();
    }

    public void addLoginActionListener(ActionListener listener){
        loginButton.addActionListener(listener);
    }

}
