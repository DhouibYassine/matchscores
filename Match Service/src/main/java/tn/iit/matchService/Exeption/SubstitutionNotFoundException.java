package tn.iit.matchService.Exeption;

public class SubstitutionNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SubstitutionNotFoundException(Long id) {
		super(Long.toString(id));
	}
}
