package com.codegym.task.task36.task3608.controller;

import com.codegym.task.task36.task3608.model.Model;
import com.codegym.task.task36.task3608.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getDataModel());
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }
}
