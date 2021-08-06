package com.techelevator.model;

import java.time.LocalDate;

public class Session {
    private Integer sessionId;
    private Integer userId;
    private Integer deckId;
    private Integer attemptedQuizCount;
    private Integer markRightCount;
    private Integer markWrongCount;
    private Integer totalMarkRightCount;
    private LocalDate sessionDate;

    public Session() {

    }

    public Session(Integer sessionId, Integer userId, Integer deckId, Integer attemptedQuizCount, Integer markRightCount, Integer markWrongCount, Integer totalMarkRightCount, LocalDate sessionDate) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.deckId = deckId;
        this.attemptedQuizCount = attemptedQuizCount;
        this.markRightCount = markRightCount;
        this.markWrongCount = markWrongCount;
        this.totalMarkRightCount = totalMarkRightCount;
        this.sessionDate = sessionDate;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeckId() {
        return deckId;
    }

    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }

    public Integer getAttemptedQuizCount() {
        return attemptedQuizCount;
    }

    public void setAttemptedQuizCount(Integer attemptedQuizCount) {
        this.attemptedQuizCount = attemptedQuizCount;
    }

    public Integer getMarkRightCount() {
        return markRightCount;
    }

    public void setMarkRightCount(Integer markRightCount) {
        this.markRightCount = markRightCount;
    }

    public Integer getMarkWrongCount() {
        return markWrongCount;
    }

    public void setMarkWrongCount(Integer markWrongCount) {
        this.markWrongCount = markWrongCount;
    }

    public Integer getTotalMarkRightCount() {
        return totalMarkRightCount;
    }

    public void setTotalMarkRightCount(Integer totalMarkRightCount) {
        this.totalMarkRightCount = totalMarkRightCount;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }
}
