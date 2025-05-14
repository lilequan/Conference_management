package org.example.conference_management.service.Admin_service;

import org.example.conference_management.pojo.R;

public interface AdminService {
    R SelectUnReviewConferenceAll();

    R ConferenceReview(int conference_id);

    R alterUserPower(int userId);

    R selectUserAll();
}
