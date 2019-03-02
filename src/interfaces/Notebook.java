package interfaces;

public interface Notebook {
    void addNote(Note note);
    void removeNote(int noteId);
    void editNote(int noteId);
    void showAllNotes();
}
