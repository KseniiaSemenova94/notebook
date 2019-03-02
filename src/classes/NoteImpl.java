package classes;

import interfaces.Note;

import java.util.Date;

public class NoteImpl implements Note {
   private int id;
   private String type;
   private String content;
   private Date creationDate;
   private Date lastModified;

   public NoteImpl(String type, String content) {
      this.type = type;
      this.content = content;
      this.creationDate = new Date();
   }
}
