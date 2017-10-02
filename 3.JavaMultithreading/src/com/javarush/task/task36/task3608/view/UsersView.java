package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by XE on 08.07.2017.
 */
public class UsersView implements View {
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        StringBuilder sb;
        if (modelData.isDisplayDeletedUserList())
            sb = new StringBuilder("All deleted users:\n");
        else sb = new StringBuilder("All users:\n");
        for (User user : modelData.getUsers()) {
            sb.append("\t").append(user).append("\n");
        }
        sb.append("===================================================");
        System.out.println(sb);
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
