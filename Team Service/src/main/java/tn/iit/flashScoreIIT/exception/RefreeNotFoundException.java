package tn.iit.flashScoreIIT.exception;

public class RefreeNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public RefreeNotFoundException(Long id) {
        super(Long.toString(id));
    }
}
