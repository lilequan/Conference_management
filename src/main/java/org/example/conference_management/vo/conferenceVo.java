package org.example.conference_management.vo;

import lombok.Data;

@Data
public class conferenceVo {
    private String conference_name;
    private String invitation_code;
    private int convener_id;
}
