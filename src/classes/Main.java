package classes;

import interfaces.Notebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader reader = null;
    private static String owner = null;
    private static Integer option = null;

    public static void main(String[] args) throws IOException {
        System.out.println("Привет, это блокнот! Пожалуйста, введите имя владельца.");
        reader = new BufferedReader(new InputStreamReader(System.in));
        int ownerLength;

        do {
           owner = reader.readLine();
            String replace;
             if (owner.contains(" ")) {
                 replace = owner.trim();
                 ownerLength = replace.length();
                 owner = replace;
             } else
                 ownerLength = owner.length();
        } while (ownerLength == 0);

        Notebook notebook = new NotebookImpl(owner);
        System.out.println("Рада помочь, " + owner + ". С чего начнём? Выберите номер действия.");

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
                   handleRemoveNote(notebook);
               }
               if (option == 4) {
                   handleEditNote(notebook);
               }
           }
       } while (option == null || option != 5);
       reader.close();
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
        Note note = new Note(typeNote, nameNote, contentName);
        notebook.addNote(note);
    }

    private static void handleShowAllNotes(Notebook notebook) {
        notebook.showAllNotes();

    }

    private static void handleRemoveNote(Notebook notebook) throws IOException {
        do {
            System.out.println("Введите ID записи, которую вы хотите удалить.");
            System.out.println("Нажмите 0, если передумали удалять запись.");
            option = readOption();
            if (option != null && option == 0) {
                break;
            }
            if (option == null || option < 0) {
                System.out.println("Несуществующий ID. Введите, пожалуйста, число.");
            } else {
                if (notebook.removeNote(option)) {
                    System.out.println("Запись с ID:" + option + " удалена.\n");
                } else {
                    System.out.println("Записи с таким ID не существует.\n");
                }
            }
        } while (option == null || option <= 0);
    }

    private static void handleEditNote(Notebook notebook) throws IOException {
        System.out.println("Введите новый текст для записи.");
        String newContent = reader.readLine();
        do {
            System.out.println("Введите ID записи, в которую вы хотите внести изменения.");
            System.out.println("Нажмите 0, если передумали вносить изменения в запись.");
            option = readOption();
            if (option != null && option == 0) {
                break;
            }
            if (option == null || option <= 0) {
                System.out.println("Несуществующий ID. Введите, пожалуйста, число.");
            } else {
                if (notebook.editNote(option, newContent)) {
                    System.out.println("Текст записи с ID" + option + " изменен.\n");
                } else {
                    System.out.println("Записи с таким номером ID не существует.\n");
                }
            }
        } while (option == null || option <= 0);
    }
}
