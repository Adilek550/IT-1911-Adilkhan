package com.company;

import java.util.Arrays;
import java.util.List;

public class Password {
    // passwordStr // it should contain uppercase and lowercase letters and digits
    // and its length must be more than 9 symbols
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(User user) {
        Password password = user.getPassword();
        String userPassword = password.getPassword();
        boolean haveDigit = false,
                haveUpperCase = false,
                haveLowerCase = false;
        if (userPassword.length() >= 9) {
            for (int i = 0; i < userPassword.length(); i++) {
                Character c = userPassword.charAt(i);
                if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ||
                        c == '0') {
                    haveDigit = true;

                }
                return haveDigit && haveLowerCase && haveUpperCase;
            }
        }
    }
}
