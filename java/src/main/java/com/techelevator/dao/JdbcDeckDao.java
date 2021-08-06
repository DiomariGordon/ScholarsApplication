package com.techelevator.dao;

import com.techelevator.model.Deck;
import com.techelevator.model.DeckUser;
import com.techelevator.model.FlashCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcDeckDao implements DeckDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createDeck(Deck deck) {

        String sql = "INSERT INTO deck (deck_name, description) " +
                "VALUES(?, ?) RETURNING deck_id;";
        Integer deckId = jdbcTemplate.queryForObject(sql, Integer.class,
                deck.getName(), deck.getDescription());
        deck.setDeckId(deckId);

        return true;
    }

    @Override
    public boolean addDeckUser(Deck deck){

        String sql = "INSERT INTO deck_user( deck_id, user_id)" +
                "VALUES( ?, ?)RETURNING deck_id ;";
        Integer deckId = jdbcTemplate.queryForObject(sql, Integer.class, deck.getDeckId(), deck.getUserId());
        return true;
    }

    @Override
    public Deck getDeckByDeckId(Integer deckId) {
        Deck deck = null;


        String sql = "SELECT deck_name from deck WHERE deck_id = ? ";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, deckId);
        while (rowSet.next()){
            deck = mapRowToDeck(rowSet);
        }
        return deck;
    }

    @Override
    public boolean updateDeckName(Deck deck) {

        String sql = "UPDATE deck SET deck_name = ? " +
                " WHERE deck_id = ?";
        jdbcTemplate.update(sql, deck.getName(),
                deck.getDeckId());
        return true;

    }

    @Override
    public boolean updateDeckContents(FlashCard flashCard) {
        return false;
    }

    @Override
    public List<Deck> getDeckByUserId(Integer userId) {
        return null;
    }

    private Deck mapRowToDeck(SqlRowSet rowSet) {
        Deck deck = new Deck();
        deck.setDeckId(rowSet.getInt("deck_id"));
        deck.setName(rowSet.getString("deck_name"));
        deck.setDescription(rowSet.getString("description"));

        return deck;
    }

}
