enum Gender {
	MALE, FEMALE, NONBINARY
}

enum JobTitle {
	STAFF, MANAGER
}

public class Staff {

	private String name;
	private int employeeID;
	private Gender gender;
	private JobTitle jobTitle;

	/**
	 * 
	 * @param name
	 * @param employeeID
	 * @param gender
	 * @param jobTitle
	 */
	public Staff(String name, int employeeID, Gender gender, JobTitle jobTitle) {
		this.name = name;
		this.employeeID = employeeID;
		this.gender = gender;
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return this.name;
	}

	public int getemployeeID() {
		return this.employeeID;
	}

	public Gender getGender() {
		return this.gender;
	}

	public JobTitle getjobTitle() {
		return this.jobTitle;
	}

	// to implement with order class
	public void takeOrder() {
		// TODO - implement Staff.takeOrder
		throw new UnsupportedOperationException();
	}

}