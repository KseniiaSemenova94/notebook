package interfaces;

import java.util.Date;

public interface Note {
    int getId();
    String getContent();
    String getType();
    String getCreationDate();
    String getLastModified();
    String getName();
    void setType(String type);
    void setName(String name);
    void setContent(String content);
}
