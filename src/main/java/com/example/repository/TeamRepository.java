package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

import java.util.List;

@Repository
public class TeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("leagueName"));
		team.setTeamName(rs.getString("teamName"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};

	public List<Team> findAll() {
		String sql = "SELECT team_name FROM teams ORDER BY inauguration";

		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);

		return teamList;
	}

	public Team load(Integer id) {
		String sql = "SELECT team_name,headquarters,inauguration,history FROM teams WHERE id=:id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);

		return team;
	}
}
