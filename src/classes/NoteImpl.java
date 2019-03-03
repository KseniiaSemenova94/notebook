package classes;

import interfaces.Note;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteImpl implements Note {
    private static int noteCounter = 0;

    private int id;
    private String type;
    private String name;
    private String content;
    private Date creationDate;
    private Date lastModified;
    private SimpleDateFormat dateFormat;

    public NoteImpl(String type, String name, String content) {
        this.type = type;
        this.content = content;
        this.creationDate = new Date();
        this.lastModified = new Date();
        this.id = ++noteCounter;
        this.name = name;
        this.dateFormat = new SimpleDateFormat();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return this.dateFormat.format(creationDate);
    }

    public String getLastModified() {
        return this.dateFormat.format(lastModified);
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
