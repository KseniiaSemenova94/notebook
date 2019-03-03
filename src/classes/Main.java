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
        String owner = reader.readLine();
        Notebook notebook = new NotebookImpl(owner);
        System.out.println("Рада помочь, " + owner + ". С чего начнём? Выберите номер действия.");
        int number = 0;
        while (number != 5) {
            System.out.println(
                    "1. Создать новую запись.\n" +
                            "2. Посмотреть все записи.\n" +
                            "3. Удалить запись.\n" +
                            "4. Редактировать запись.\n" +
                            "5. Завершить работу с программой.\n");

            number = readNumber();
            if (number < 1 || number > 5) {
                System.out.println("Введите число из списка.");
            } else {
                if (number == 1) {
                    System.out.println("Выберите тему записи.\n" +
                            "1. Идея.\n" +
                            "2. Мысль.\n" +
                            "3. Дело.\n" +
                            "4. Цель.\n" +
                            "5. Без темы.\n");
                    number = readNumber();
                }
            }

        }
        String text = "";


        while (!text.equals("stop")) {
            text = reader.readLine();
            Note note = new NoteImpl("Мысль", "мой день", text);
            notebook.addNote(note);
            notebook.showAllNotes();
        }


    }

    private static int readNumber() throws IOException {
        int number = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный номер действия. Ввведите, пожалуйста, число.");
        }
        return number;
    }
}
