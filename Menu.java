package com.company;
public interface Menu {
    void show();
}

public class InfoMenu implements Menu {
    @Override
    public void show() {
        //show user menu
    }
}

public class InfoUserMenu implements Menu {
    @Override
    public void show() {
        //show admin menu
    }
}
public class InhoUser implements Menu {
    @Override
    public Menu getMenu();

}
