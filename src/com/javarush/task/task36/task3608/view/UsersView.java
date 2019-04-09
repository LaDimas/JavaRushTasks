package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View{
    private Controller controller;
    private MainModel mainModel = null;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void refresh(ModelData modelData){
        System.out.println(modelData.isDisplayDeletedUserList()? "All deleted users:" :"All users:");
        modelData.getUsers().forEach(n -> System.out.println("\t" + n));
        System.out.println("===================================================");
    }

    @Override
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}
