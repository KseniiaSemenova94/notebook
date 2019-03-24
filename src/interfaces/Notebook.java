package interfaces;

import classes.Note;

public interface Notebook {
    void addNote(Note note);
    boolean removeNote(int noteId);
    boolean editNote(int noteId, String content);
    void showAllNotes();
}
