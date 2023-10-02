package com.codegym.task.task36.task3608.view;

import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.DataModel;

public class UsersView implements View {

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(DataModel dataModel) {
        if (dataModel.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }else System.out.println("All users:");

        for (User user : dataModel.getUsers()) {
            System.out.println("\t" + user);
        }
        System.out.println("===================================================");
    }
    public void fireOpenUserEditFormEvent(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void fireShowAllUsersEvent() {
        controller.onShowAllUsers();
    }

    public void fireShowDeletedUsersEvent() {
        controller.onShowAllDeletedUsers();
    }
}
