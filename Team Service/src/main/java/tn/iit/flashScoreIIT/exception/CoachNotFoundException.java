package tn.iit.flashScoreIIT.exception;

public class CoachNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public CoachNotFoundException(Long id) {
        super(Long.toString(id));
    }
}
