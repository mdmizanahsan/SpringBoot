package com.mizan.user_dashboard_api.service.impl;

import com.mizan.user_dashboard_api.entity.Team;
import com.mizan.user_dashboard_api.repository.TeamRepository;
import com.mizan.user_dashboard_api.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(String id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public Team updateTeam(String id, Team team) {
        Team existing = getTeamById(id);
        if (team.getName() != null) existing.setName(team.getName());
        return teamRepository.save(existing);
    }

    public void deleteTeam(String id) {
        teamRepository.deleteById(id);
    }
}
