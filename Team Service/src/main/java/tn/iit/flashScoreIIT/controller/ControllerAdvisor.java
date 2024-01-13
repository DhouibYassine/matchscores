package tn.iit.flashScoreIIT.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tn.iit.flashScoreIIT.exception.CoachNotFoundException;
import tn.iit.flashScoreIIT.exception.PlayerNotFoundException;
import tn.iit.flashScoreIIT.exception.RefreeNotFoundException;
import tn.iit.flashScoreIIT.exception.TeamNotFoundException;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private static final String TIMESTAMP = "timestamp";

    private static final String MESSAGE = "message";

    @ExceptionHandler(CoachNotFoundException.class)
    public ResponseEntity<Object> handleCoachNotFoundException(CoachNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE, "Coach with id " + ex.getMessage() + " is not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Object> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE, "Player with id " + ex.getMessage() + " is not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RefreeNotFoundException.class)
    public ResponseEntity<Object> handleRefreeNotFoundException(RefreeNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE,"Refree with id " + ex.getMessage() + " is not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<Object> handleTeamNotFoundException(TeamNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE,"Team with id " + ex.getMessage() + " is not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
