package models;

public class Project {

    private String projectId;
    private String name;
    private String companyId;

    public Project(String projectId, String name, String companyId) {
        this.projectId = projectId;
        this.name = name;
        this.companyId = companyId;
    }

    public Project() {}

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void yourProject(String project) {
        name = project;
        System.out.println("Project: "+ name);
    }
}
