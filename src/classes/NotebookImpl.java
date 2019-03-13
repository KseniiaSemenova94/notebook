package classes;

import interfaces.Note;
import interfaces.Notebook;

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
    public boolean removeNote(int noteId) {
        if ((this.firstEmptyCell <= this.notes.length / 2) && (this.notes.length > 10)) {
            decreaseNotebookSize();
        }
        int noteIdIndexToRemove = findNoteIndexById(noteId);
        if (noteIdIndexToRemove == -1) {
            return false;
        }
        System.arraycopy(this.notes, noteIdIndexToRemove + 1,
                this.notes, noteIdIndexToRemove, firstEmptyCell - 1);
        this.notes[firstEmptyCell-1] = null;
        firstEmptyCell--;
        return true;
    }

    @Override
    public boolean editNote(int noteId, String content) {
        int noteIDToChange = findNoteIndexById(noteId);
        if (noteIDToChange == -1) {
            return false;
        }
        this.notes[noteIDToChange].setContent(content);
        return true;
    }

    @Override
    public void showAllNotes() {
        for (int i = 0; i < this.firstEmptyCell; i++) {
            showNote(this.notes[i]);
        }
        System.out.println();
    }

    private void increaseNotebookSize() {
        Note[] newNotes = new Note[(int) (this.notes.length * 1.5 + 1)];
        System.arraycopy(this.notes, 0, newNotes, 0, this.notes.length);
        this.notes = newNotes;
    }

    private int findNoteIndexById(int noteId) {
        for (int i = 0; i < this.notes.length; i++) {
            if (this.notes[i].getId() == noteId) {
                return i;
            }
        }
        return -1;
    }

    private void decreaseNotebookSize() {
        Note[] newNote = new Note[(int) (this.notes.length / 1.3)];
        System.arraycopy(this.notes, 0, newNote, 0, this.firstEmptyCell);
        this.notes = newNote;
    }



    private void showNote(Note note) {
        String leftAlignFormat = "| %-4s | %-22s | %-75s | %-19s | %-19s |%n";
        System.out.format("+------+------------------------+-----------------------------------------------------------------------------+---------------------+---------------------+%n");
        System.out.format("|  ID  |  Type                  |  Title                                                                      |  Creation Date      |  Last Modified Date |%n");
        System.out.format("+-------------------------------+-----------------------------------------------------------------------------+---------------------+---------------------+%n");
        System.out.format(leftAlignFormat, note.getId(), note.getType(), note.getName(), note.getCreationDate(), note.getLastModified());
        System.out.format("+------+------------------------+-----------------------------------------------------------------------------+---------------------+---------------------+%n");
        System.out.println( " " + note.getContent());
        System.out.format("+------+------------------------+-----------------------------------------------------------------------------+---------------------+---------------------+%n");
    }
}
