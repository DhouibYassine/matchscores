package tn.iit.flashScoreTn.exceptions;

public class LeagueNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LeagueNotFoundException(Long id) {
        super(Long.toString(id));
    }
}
