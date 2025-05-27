package org.example.conference_management.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.Value;

import java.util.Date;


@Data
public class user_conferenceVo {
    private int conference_id;
    private int user_id;
    private String round_trip_time;
    private String accommodation_requirements;
    private String remarks;

    private String inv_Code;
}
