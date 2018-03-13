package userWebChat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
     private int id;
     private int fromId;
     private int toId;
     private String text;
     private String  timesTamp;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getFromId() {
          return fromId;
     }

     public void setFromId(int fromId) {
          this.fromId = fromId;
     }

     public int getToId() {
          return toId;
     }

     public void setToId(int toId) {
          this.toId = toId;
     }

     public String getText() {
          return text;
     }

     public void setText(String text) {
          this.text = text;
     }

     public String getTimesTamp() {
          return timesTamp;
     }

     public void setTimesTamp(String timesTamp) {
          this.timesTamp = timesTamp;
     }


}
