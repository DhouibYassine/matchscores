package tn.iit.flashScoreTn.exceptions;

public class MatchDayNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public MatchDayNotFoundException(long id) {
        super(Long.toString(id));
    }
}
