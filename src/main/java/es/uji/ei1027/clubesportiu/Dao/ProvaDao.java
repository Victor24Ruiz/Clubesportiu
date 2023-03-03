package es.uji.ei1027.clubesportiu.Dao;

import es.uji.ei1027.clubesportiu.Model.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProvaDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Prova> getProves() {
        try {
            return jdbcTemplate.query("SELECT * FROM Prova", new ProvaRowMapper());
        } catch ( EmptyResultDataAccessException e ) {
            return new ArrayList<Prova>();
        }
    }
}
