package tn.iit.flashScoreIIT.exception;

public class PlayerNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public PlayerNotFoundException(Long id) {
        super(Long.toString(id));
    }
}
