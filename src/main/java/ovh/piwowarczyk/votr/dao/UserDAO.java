package ovh.piwowarczyk.votr.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ovh.piwowarczyk.votr.model.User;

public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createUser(User user){
        String query = "";

        return jdbcTemplate.update(query);
    }

    public int updateUser(User user){
        String query = "";

        return jdbcTemplate.update(query);
    }

    public int deleteUser(User user){
        String query = "";

        return jdbcTemplate.update(query);
    }
}
