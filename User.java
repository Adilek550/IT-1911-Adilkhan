package com.company;

import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;

    public class User {
        // id (you need to generate this id by static member variable)
        // name, surname
        // username
        // password
        private int id;
        private static int id_gen = 0;
        private String name;
        private String surname;
        private String username;
        private String password;
        private Password passwordStr;

        private void readId()  {
            try{
                File file = new File ("D:\\загрузки\\db (1).txt\"");
                Scanner sc = new Scanner (file);
                while(sc.hasNextLine()){
                    id_gen = sc.nextInt();
                }
            }
            catch(Exception e){
                System.out.println("User.readId : File not found" + e);
            }
            ++id_gen;
        }

        private void idGen() {
            readId();
            id = id_gen++;
        }

        public User(){
            idGen();
        }

        public User(String username, String passwordStr){
            this();
            setUsername(username);
            setPassword(new String(passwordStr));
        }
        // For Sign Up
        public User(String name, String surname, String username, String passwordStr){
            this();
            setName(name);
            setSurname(surname);
            setUsername(username);
            setPassword(new String(passwordStr));
        }
        // Constructor for exist Users
        protected User(int id, String name, String surname, String username, String passwordStr){
            this.id = id;
            setName(name);
            setSurname(surname);
            setUsername(username);
            setPassword(new String(passwordStr));
        }

        public int getId(){
            return id;
        }

        public String getName(){
            return name;
        }

        public String getSurname(){
            return surname;
        }

        public String getUsername(){
            return username;
        }

        public String getPassword(){
            return String.getPasswordStr();
        }

        public void setName(String name){
            this.name = name;
        }

        public void setSurname(String surname){
            this.surname = surname;
        }

        public void setUsername(String username){
            this.username = username;
        }

        public void setPassword(String password){
            this.password = password;
        }

        @Override
        public String toString(){
            return id + " " + name  + " " + surname + " " + username + " " + getPassword();
        }

    }