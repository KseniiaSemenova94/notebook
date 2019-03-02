package classes;

import interfaces.Note;
import interfaces.Notebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Привет, мудила! Пиши свою херню тут, удачи!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        Notebook notebook = new NotebookImpl("Ксения Семенова");

        while (!text.equals("stop")) {
            text = reader.readLine();
            Note note = new NoteImpl("Мысль", text);
            notebook.addNote(note);
            notebook.showAllNotes();
        }
    }
}
