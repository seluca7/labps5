package com.ps.lab.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class AdminW extends JFrame{
    private JPanel myPanel;
    private JTextField idTextField;
    //private JTextField userField1;
    private JRadioButton adminRadioButton;
    private JTable table1;
    private JButton allUsersButton;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton userByIDButton;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public AdminW(){
        add(myPanel);
        setTitle("Admin interface");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Icon radioAdmin(){
        return adminRadioButton.getSelectedIcon();
    }


    /*
    public Long getIdValue(){
        return Long.parseLong(idTextField.getText());
    }

    public String getUserText(){
        return userField1.getText();
    }
    public String getPasswordText(){
        return passwordField1.getText();
    }
    */
    public String getUserIdValue(){
        return idTextField.getText();
    }

    public String getUsernameValue(){
        return textField1.getText();
    }

    public String getPasswordValue(){
        return passwordField1.getText();
    }
   // public String getAdminValue(){
   //     return textField4.getText();
   // }

   // public Long getIdSearchValue(){
   //     return Long.parseLong(textField5.getText());
   // }

    public void refreshUserTable(Object[][] data, String[] columnNames){
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }

    public void addAllUsersButtonListener(ActionListener listener){
        allUsersButton.addActionListener(listener);
    }

    public void addCreateButton(ActionListener listener){
        createButton.addActionListener(listener);
    }

    public void addDeleteButton(ActionListener listener){
        deleteButton.addActionListener(listener);
    }

    public void addUpdateButton(ActionListener listener){
        updateButton.addActionListener(listener);
    }

    public void addUserByIDButton(ActionListener listener){
        userByIDButton.addActionListener(listener);
    }

}
