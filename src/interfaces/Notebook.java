package interfaces;

public interface Notebook {
    void addNote(Note note);
    boolean removeNote(int noteId);
    void editNote(int noteId);
    void showAllNotes();
}
