package tn.iit.flashScoreTn.exceptions;

public class SeasonNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public SeasonNotFoundException(long id) {
        super(Long.toString(id));
    }
}
