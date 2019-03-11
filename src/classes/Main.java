package classes;

import interfaces.Note;
import interfaces.Notebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader reader = null;
    private static String owner = null;

    public static void main(String[] args) throws IOException {
        System.out.println("Привет, это блокнот! Пожалуйста, введите имя владельца.");
        reader = new BufferedReader(new InputStreamReader(System.in));
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
        Integer option;

       do {
           System.out.println(
                   "1. Создать новую запись.\n" +
                           "2. Посмотреть все записи.\n" +
                           "3. Удалить запись.\n" +
                           "4. Редактировать запись.\n" +
                           "5. Завершить работу с программой.\n");
           option = readOption();
           if (option == null || option < 1 || option > 5) {
               System.out.println("Некорректный номер действия. Ввведите, пожалуйста, число из списка.");
           } else {
               if (option == 1) {
                   handleAddNote(notebook);
               }
               if (option == 2) {
                   handleShowAllNotes(notebook);
               }
               if (option == 3) {
                   handleRemoveNote();
               }
               if (option == 4) {
                   handleEditNote();
               }
           }
       } while (option == null || option != 5);
    }

    private static Integer readOption() throws IOException {
        Integer option;
        try {
            option = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return null;
        }
        return option;
    }

    private static void handleAddNote(Notebook notebook) throws IOException {
        System.out.println(owner +", введите тему записи (идея, мысль, дело, цель и т.п.).");
        String typeNote = reader.readLine();
        System.out.println(owner + ", введите название записи.");
        String nameNote = reader.readLine();
        System.out.println(owner + ", введите текст записи.");
        String contentName = reader.readLine();
        System.out.println();
        Note note = new NoteImpl(typeNote, nameNote, contentName);
        notebook.addNote(note);
    }

    private static void handleShowAllNotes(Notebook notebook) {
        notebook.showAllNotes();

    }

    private static void handleRemoveNote() {

    }

    private static void handleEditNote() {

    }
}
