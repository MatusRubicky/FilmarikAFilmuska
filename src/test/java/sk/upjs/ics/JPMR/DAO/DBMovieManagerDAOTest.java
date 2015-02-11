/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.JPMR.DAO;

import java.io.File;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.JPMR.Movie;
import sk.upjs.ics.JPMR.UserMovie;

/**
 *
 * @author Uživateľ
 */
public class DBMovieManagerDAOTest {
    
    private JdbcTemplate jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
    
    public DBMovieManagerDAOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getMovieNumber method, of class DBMovieManagerDAO.
     */
    @Test
    public void testGetMovieNumber() {
        System.out.println("getMovieNumber");
        
        int expResult = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Filmy");
        
        String testName = "testName";
        jdbcTemplate.update("INSERT INTO Filmy(meno) VALUES(?)", testName);
        
        int result = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Filmy");
        
        jdbcTemplate.update("DELETE FROM Filmy WHERE meno=?", testName);
        
        assertEquals(expResult, result-1);
    }

    /**
     * Test of deleteMovie method, of class DBMovieManagerDAO.
     */
    @Test
    public void testDeleteMovie() {
        System.out.println("deleteMovie");
        
        jdbcTemplate.update("INSERT INTO Spoj(IdU, IdF) VALUES(0, 0)");
        int expResult = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Spoj");        
        
        jdbcTemplate.update("DELETE FROM Spoj WHERE IdU=0 AND IdF=0");
        int result = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Spoj");
    }

    /**
     * Test of addMovie method, of class DBMovieManagerDAO.
     */
    @Test
    public void testAddMovie() {
        System.out.println("addMovie");
        
        int expResult = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Filmy");
        
        String testName = "testName";
        jdbcTemplate.update("INSERT INTO Filmy(meno) VALUES (?)", testName);        
        int result = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Filmy");
        
        jdbcTemplate.update("DELETE FROM Filmy WHERE meno=?", testName);        
        assertEquals(expResult, result-1);
    }

    /**
     * Test of checkMovieExistence method, of class DBMovieManagerDAO.
     */
    @Test
    public void testCheckMovieExistence() {
        System.out.println("checkMovieExistence");
        
        int expResult = 1;
        
        String testName = "testName";
        jdbcTemplate.update("INSERT INTO Filmy(meno) VALUES (?)", testName);        
        int result = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Filmy WHERE meno=?", testName);
        
        jdbcTemplate.update("DELETE FROM Filmy WHERE meno=?", testName);
    }    
}
