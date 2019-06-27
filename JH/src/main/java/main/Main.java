package main;

import DBService.DBService;
import DBService.dataSets.UsersDataSet;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.printConnectionInfo();
        try {
            long userId = dbService.addUser("Boss2", 7);
            System.out.println("Added user id: " + userId);

            UsersDataSet dataSet = dbService.getUser(userId);
            System.out.println("User data set: " + dataSet);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
