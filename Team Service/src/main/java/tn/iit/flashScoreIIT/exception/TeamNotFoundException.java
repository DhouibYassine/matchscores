package tn.iit.flashScoreIIT.exception;

public class TeamNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public TeamNotFoundException(Long id) {
        super(Long.toString(id));
    }
}
