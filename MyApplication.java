package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyApplication {
    // users - a list of users
    private Scanner ad = new Scanner(System.in);
    private User signedUser;
    private LinkedList<User> userLinkedList;

    private void addUser(User user)
    {
        userLinkedList.add(user);
    }

    public MyApplication() {

        userLinkedList = new LinkedList<>();
    }

    private void menu() throws FileNotFoundException, UnsupportedEncodingException {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = ad.nextInt();
                if (choice == 1) authentication();
                else break;
            }
            else {
                userProfile();
            }
        }
    }

    private void userProfile() throws FileNotFoundException, UnsupportedEncodingException {
        while(true){
            System.out.println("1.Log off");
            int choice = ad.nextInt();
            if(choice == 1) logOff();
        }
    }

    private void logOff() throws FileNotFoundException, UnsupportedEncodingException {
        signedUser = null;
        start();
    }

    private void authentication() {
        while (true) {
            System.out.println("1.Sign in");
            System.out.println("2.Sign up");
            int choice =ad.nextInt();
            if(choice == 1) signIn();
            else signUp();
        }
    }

    private void signIn() {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        String password = scanner.next();
        Password passwordStr = new Password(password);
        for(User user : userLinkedList){
            if(username.equals(user.getUsername()) && passwordStr.equals(user.getPassword())){
                signedUser = user;

            }
        }
    }

    private void signUp() {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        String username = scanner.next();
        String name = scanner.next();
        String surname =scanner.next();
        if(password != null && username != null && name != null &&surname != null){
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            Password passwordStr = new Password(password);
            user.setPassword(password=passwordStr);
            if(passwordStr.checkPassword(user)){
                addUser(user);
                authentication();
            }
        }
    }

    public void start() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("\"D:\\загрузки\\db (1).txt\"");
        Scanner fileScanner = new Scanner(file);

        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Menu");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                menu();
            } else {
                break;
            }
        }

        saveUserList();
    }

    private void saveUserList() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("db (1).txt","UTF-8");
        for(User user : userLinkedList){
            printWriter.println("Username "+user.getUsername() + ",name" + user.getName() + ",surname" + user.getSurname()
                    + ",password" + user.getPassword());
        }
        printWriter.close();
    }
}
