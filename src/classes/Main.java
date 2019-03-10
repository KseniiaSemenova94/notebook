package classes;

import interfaces.Note;
import interfaces.Notebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Привет, это блокнот! Пожалуйста, введите имя владельца.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String owner;
        int ownerLength;

        do {
           owner = reader.readLine();
            String replace;
             if (owner.contains(" ")) {
                 replace = owner.replace(" ", "");
                 ownerLength = replace.length();
             } else
                 ownerLength = owner.length();
        } while (ownerLength == 0);

        Notebook notebook = new NotebookImpl(owner);
        System.out.println("Рада помочь, " + owner + ". С чего начнём? Выберите номер действия.");
        System.out.println(
                "1. Создать новую запись.\n" +
                        "2. Посмотреть все записи.\n" +
                        "3. Удалить запись.\n" +
                        "4. Редактировать запись.\n" +
                        "5. Завершить работу с программой.\n");
        Integer option;
       do {
           option = readOption();
           if (option == null || option < 1 || option > 5) {
               System.out.println("Некорректный номер действия. Ввведите, пожалуйста, число из списка.");
           }
       } while (option == null || option < 1 || option > 5);

       while (option != 5) {
           if (option == 1) {
               handleAddNote();
           }
           if (option ==2) {
               handleShowAllNotes();
           }
           if (option ==3) {
               handleRemoveNote();
           }
           if (option ==4) {
               handleEditNote();
           }
       }
    }

    private static Integer readOption() throws IOException {
        Integer option;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            option = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return null;
        }
        return option;
    }

    private static void handleAddNote() {
        System.out.println("Выберите тему записи.\n" +
                "1. Идея.\n" +
                "2. Мысль.\n" +
                "3. Дело.\n" +
                "4. Цель.\n" +
                "5. Без темы.\n");
//        number = readNumber();
    }

    private static void handleShowAllNotes() {

    }

    private static void handleRemoveNote() {

    }

    private static void handleEditNote() {

    }
}
