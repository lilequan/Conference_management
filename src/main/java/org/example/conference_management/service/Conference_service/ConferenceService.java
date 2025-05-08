package org.example.conference_management.service.Conference_service;

import org.example.conference_management.pojo.R;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.user_conferenceVo;

public interface ConferenceService {



    R CreateConference(conferenceVo conferenceVo);

    R JoinConference(user_conferenceVo ucv);

    R alterInv_code(int conference_id, String invitation_code);

    R selectConferenceAll(int convener_id);

    R alterConference(int conference_id, String conference_name);

    R deleteConference(int conference_id);
}
