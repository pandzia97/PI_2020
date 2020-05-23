package ovh.piwowarczyk.votr.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ovh.piwowarczyk.votr.model.Survey;

public class SurveyDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createSurvey(Survey survey){
        String query = "";

        return jdbcTemplate.update(query);
    }

    public int updateSurvey(Survey survey){
        String query = "";

        return jdbcTemplate.update(query);
    }

    public int deleteSurvey(Survey survey){
        String query = "";

        return jdbcTemplate.update(query);
    }
}
