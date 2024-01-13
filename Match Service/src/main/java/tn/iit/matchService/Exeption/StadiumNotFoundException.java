package tn.iit.matchService.Exeption;

public class StadiumNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StadiumNotFoundException(Long id) {
		super(Long.toString(id));
	}
}
