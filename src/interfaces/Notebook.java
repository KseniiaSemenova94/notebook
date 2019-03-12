package interfaces;

public interface Notebook {
    void addNote(Note note);
    boolean removeNote(int noteId);
    boolean editNote(int noteId);
    void showAllNotes();
}
