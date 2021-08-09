package com.techelevator.dao;

import com.techelevator.model.Deck;
import com.techelevator.model.DeckUser;
import com.techelevator.model.FlashCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

//        String sql
        return false;
    }

    @Override
    public List<Deck> getDeckByUserId(Integer userId) {
        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT d.deck_name, d.description FROM deck d " +
                "JOIN deck_user du ON du.deck_id = d.deck_id " +
                "JOIN users u ON u.user_id = du.user_id " +
                "WHERE u.user_id = ?; ";


        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()){
            Deck deck = mapRowToDeck2(rowSet);
            if (deck != null) {
                decks.add(deck);
            }
        }
        return decks;
    }


    @Override
    public boolean addCardToDeck(Deck deck) {

        String sql = "INSERT INTO flashcard_deck( deck_id, flashcard_id)" +
                "VALUES( ?, ?)RETURNING deck_id ;";
        for(int i = 0; i < deck.getCards().length; i++) {
        Integer deckId = jdbcTemplate.queryForObject(sql, Integer.class, deck.getDeckId(), deck.getCards()[i]);
        }
        return true;

    }


    @Override
    public Integer getUserIdByDeckId(Integer deckId) {
        String sql = "SELECT user_id from deck_user WHERE " +
                "deck_id = ? ;";
        Integer userId = jdbcTemplate.queryForObject(sql, Integer.class, deckId);
        return userId;

    }

    private Deck mapRowToDeck(SqlRowSet rowSet) {
        Deck deck = new Deck();
        deck.setDeckId(rowSet.getInt("deck_id"));
        deck.setName(rowSet.getString("deck_name"));
        deck.setDescription(rowSet.getString("description"));

        return deck;
    }

    private Deck mapRowToDeck2(SqlRowSet rowSet) {
        Deck deck = new Deck();
        deck.setName(rowSet.getString("deck_name"));
        deck.setDescription(rowSet.getString("description"));

        return deck;
    }

}
