package classes;

import interfaces.Note;
import interfaces.Notebook;
import java.util.Arrays;

public class NotebookImpl implements Notebook {
    private Note[] notes;
    private String owner;
    private int firstEmptyCell;

    public NotebookImpl(String owner) {
        this.owner = owner;
        this.notes = new Note[10];
        this.firstEmptyCell = 0;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void addNote(Note note) {
        if (this.notes.length == this.firstEmptyCell) {
            increaseNotebookSize();
        }
        this.notes[this.firstEmptyCell] = note;
        this.firstEmptyCell++;
    }

    @Override
    public void removeNote(int noteId) {

    }

    @Override
    public void editNote(int noteId) {

    }

    @Override
    public void showAllNotes() {
        System.out.println(Arrays.toString(notes));
    }

    private void increaseNotebookSize() {
        Note[] newNotes = new Note[(int)(this.notes.length * 1.5 + 1)];
        System.arraycopy(this.notes, 0, newNotes, 0, this.notes.length);
        this.notes = newNotes;
    }
}
