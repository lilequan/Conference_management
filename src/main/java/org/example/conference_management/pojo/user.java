package org.example.conference_management.pojo;

import lombok.Data;

@Data
public class user {
   private int user_id;
   private String password;
   private String email;
   private String user_name;
   private boolean isAdmin;
}
