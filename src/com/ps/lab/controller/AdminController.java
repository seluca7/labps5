package com.ps.lab.controller;

import com.ps.lab.model.User;
import com.ps.lab.view.AdminW;
import com.ps.lab.service.UserService;
import com.ps.lab.utils.DataConverter;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {
    private final AdminW adminW;
    private final UserService userService;
    private final DataConverter dataConverter;

    public AdminController(AdminW adminPresentation, UserService userService, DataConverter dataConverter ){
        this.adminW = adminPresentation;
        this.userService = userService;
        this.dataConverter = dataConverter;


        this.adminW.addAllUsersButtonListener(new AllUsersButtonListener());
        //this.adminPresentation.addCreateUpdateDeleteActionListener(new CreateUpdateDeleteListener());
        //this.adminPresentation.addSearchButtonListener(new SearchButtonListener());

    }

    private class AllUsersButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            List<User> users = userService.findAll();
            Object[][] userData = dataConverter.userToTableData(users);
            String[] usersColumnNames = dataConverter.userToTableColumnNames();
            adminW.refreshUserTable(userData,usersColumnNames);
        }

    }
}
