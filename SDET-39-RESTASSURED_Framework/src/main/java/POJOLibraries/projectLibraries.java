package POJOLibraries;

public class projectLibraries {

	//step 1:Delare all the variables as global
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	//step 2: provide constructor to initialize
	public projectLibraries(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	//step 3: provide getters and setters 
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
}
