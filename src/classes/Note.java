package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
    private static int noteCounter = 0;

    private int id;
    private String type;
    private String name;
    private String content;
    private Date creationDate;
    private Date lastModified;
    private SimpleDateFormat dateFormat;

    public Note(String type, String name, String content) {
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

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.lastModified = new Date();
    }

    public String getCreationDate() {
        return this.dateFormat.format(creationDate);
    }

    public String getLastModified() {
        return this.dateFormat.format(lastModified);
    }

    public String getName() {
        return name;
    }
}
