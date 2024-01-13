package tn.iit.matchService.Exeption;

public class GoalNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GoalNotFoundException(Long id) {
		super(Long.toString(id));
	}
}
