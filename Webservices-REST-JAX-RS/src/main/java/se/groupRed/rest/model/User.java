package se.groupRed.rest.model;

public class User {
	
	private final Long userId;

	public User(Long userId)
	{
		this.userId=userId;
	}
	
	public Long getUserId() {
		return userId;
	}

}
