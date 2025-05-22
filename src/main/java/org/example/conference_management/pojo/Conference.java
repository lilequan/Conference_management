package org.example.conference_management.pojo;

import lombok.Data;

@Data
public class Conference {
    private int conference_id;
    private String conference_name;
    private int convener_id;
    private Integer conference_state;
    private String invitation_code;
}
