package models;

import com.google.gson.reflect.TypeToken;
import controllers.LoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import observers.Observer;
import services.GsonService;
import services.HTTPRequestService;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProjectList {
    public ArrayList<Project> projects;

    public ProjectList() {
        getProjectsFromDataBase();
    }

    public ArrayList<Project> getProjects() {
        return this.projects;
    }

    public void addProject(Project project){
        projects.add(project);
        System.out.println(projects.size());
    }

    public void getProjectsFromDataBase() {
        this.projects = new ArrayList<>();
        String jsonProjects = HTTPRequestService.getProjects(LoginController.username + ":" + LoginController.password);
        Type type = new TypeToken<Project[]>() {}.getType();
        Project[] pList = (Project[]) GsonService.fromJson(jsonProjects, type);
        for(Project p : pList) {
            this.projects.add(p);
        }
    }

}
