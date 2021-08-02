package com.techelevator.dao;

import com.techelevator.model.FlashCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcFlashCardDao implements FlashCardDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcFlashCardDao(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createFlashCard(FlashCard flashCard){

        String sql = "INSERT INTO flashcard( question, answer) " +
                "VALUES( ?, ?) RETURNING flashcard_id;";
        Integer flashCardId = jdbcTemplate.queryForObject(sql, Integer.class,
                 flashCard.getQuestion(), flashCard.getAnswer());
        flashCard.setFlashCardId(flashCardId);

        return true;
    }


}
