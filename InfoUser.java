package com.company;
public class InfoUser extends User {
    public InfoUser(String username, String password, boolean dsd) {
        super(String.username, String.password, dsd);
    }

        public InfoUser(String username, String password, boolean surname) {
            super(username, password, surname);
        }



        @Override

        public boolean login() {
            final boolean isAuthenticated = super.LogIn();
            final boolean isAuthorized = isAllowedToDoThis();
            return isAuthenticated && isAuthorized;
        }

        private boolean isAllowedToDoThis() {

}
