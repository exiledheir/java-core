package lesson05.quiz.service.impl;

import lesson05.quiz.model.Team;
import lesson05.quiz.service.TeamService;

import java.util.HashSet;
import java.util.Set;

public class TeamServiceImpl implements TeamService {

    private final Set<Team> teams = new HashSet<>();

    @Override
    public Team createTeam(String name, String slogan) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cant be null or empty");

        Team team = new Team(name, slogan);
        teams.add(team);
        return team;
    }

    @Override
    public boolean removeTeam(Team team) {
        if (team == null) throw new IllegalArgumentException("Team cant be null");
        return teams.remove(team);
    }

    @Override
    public void addScore(Team team, int point) {
        if (team == null) throw new IllegalArgumentException("Team cant be null");
        if (point < 0) throw new IllegalArgumentException("You cant add negative points");
        team.addScore(point);
    }

    public Set<Team> getTeams() {
        return new HashSet<>(teams);
    }
}
