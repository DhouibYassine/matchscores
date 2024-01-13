package tn.iit.matchService.Exeption;

public class MatchNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MatchNotFoundException(Long id) {
		super(Long.toString(id));
	}
}
