package com.company;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {
private static final String FILE_NAME = "C:\\Users\\Uglevi\\IdeaProjects\\UserWHW_43\\DB\\Users.txt";

    public static void main(String[] args) throws Exception {
        ArrayList<User> userList = new ArrayList<>();
      do {
            userList.add(inputUser());
        } while (!isExit());

      serialize(userList);

    }

    private static void serialize(ArrayList<User> userList) throws Exception {
        FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(userList);
        out.close();
        fileOut.close();


    }

    private static boolean isExit() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equalsIgnoreCase("exit")) {
            return true;
        }
        return false;
    }

    private static User inputUser() throws IOException, IllegalAccessException {
              User user = new User();
              Field[] userField = User.class.getDeclaredFields();
            for (Field field : userField) {
                field.setAccessible(true);
                System.out.println("Input please " + field.getName());
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String answer = reader.readLine();
                field.set(user, answer);
               }

        return user;
    }
}

