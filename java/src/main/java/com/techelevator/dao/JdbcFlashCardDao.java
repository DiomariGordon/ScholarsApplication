package com.techelevator.dao;

import com.techelevator.model.FlashCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFlashCardDao implements FlashCardDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcFlashCardDao(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FlashCard getFlashCardByQuestion(String question){
        FlashCard flashCard = null;
        String sql = "SELECT * FROM flashcard WHERE question = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, question);
        if(rowSet.next()){
             flashCard = mapRowToFlashCard(rowSet);
        }
        return flashCard;
    }

    @Override
    public FlashCard getFlashCardById(Integer flashCardId){

        FlashCard flashCard = null;
        String sql = "SELECT * FROM flashcard WHERE flashcard_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, flashCardId);
        if(rowSet.next()){
            flashCard = mapRowToFlashCard(rowSet);
        }
        return flashCard;
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

    @Override
    public void updateFlashCard(FlashCard flashCard) {
        String sql = "UPDATE flashcard SET question = ?, answer = ? " +
                " WHERE flashcard_id = ?";
        jdbcTemplate.update(sql, flashCard.getQuestion(),flashCard.getAnswer(),
                flashCard.getFlashCardId());
    }

    private FlashCard mapRowToFlashCard(SqlRowSet rowSet) {
        FlashCard flashCard = new FlashCard();
        flashCard.setFlashCardId(rowSet.getInt("flashcard_id"));
        flashCard.setQuestion(rowSet.getString("question"));
        flashCard.setAnswer(rowSet.getString("answer"));

        return flashCard;
    }


}
