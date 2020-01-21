package interactor;

public interface RequirementInterface {
	public boolean passEntering(String certificateId);
	public boolean passExiting(String certificateId, double fee);
}
