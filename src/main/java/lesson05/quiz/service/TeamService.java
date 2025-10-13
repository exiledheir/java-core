package lesson05.quiz.service;

import lesson05.quiz.model.Team;

import java.util.Set;

public interface TeamService {

    Team createTeam(String name, String slogan);

    boolean removeTeam(Team team);

    void addScore(Team team, int point);

    Set<Team> getTeams();
}
