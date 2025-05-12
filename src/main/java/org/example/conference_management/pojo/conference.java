package org.example.conference_management.pojo;

import lombok.Data;

@Data
public class conference {
    private int conference_id;
    private String conference_name;
    private int convener_id;
    private boolean conference_state;
    private String invitation_code;
}
