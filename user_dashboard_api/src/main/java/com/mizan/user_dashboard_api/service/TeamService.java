package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.Team;

import java.util.List;

public interface TeamService {

    Team createTeam(Team team);
    List<Team> getAllTeams();
    Team getTeamById(String id);
    Team updateTeam(String id, Team team);
    void deleteTeam(String id);
}
