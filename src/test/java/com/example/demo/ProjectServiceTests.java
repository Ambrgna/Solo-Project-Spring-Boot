package com.example.demo;

import com.genspark.SpringBootdemoApplication.Entity.Project;
import com.genspark.SpringBootdemoApplication.Service.ProjectService;
import com.genspark.SpringBootdemoApplication.SpringBootdemoApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringBootdemoApplication.class)
class ProjectServiceTests {
	private List<String> list;
	private Project p;
	private int[] teamLeads=new int[1];
	private int owner;
	private int clientid;
	private int projectid;
	@Autowired
	private ProjectService projectService;

	public ProjectServiceTests() {
		owner=0;
		clientid=0;
		teamLeads[0]=owner;
	}

	@BeforeEach
	void init() {
		System.out.println("startup");
		p = new Project(clientid,owner, teamLeads, null, "Test Project", "");
		p = projectService.addProject(p);
		projectid =p.getProjectId();
	}
	@AfterEach
	void teardown() {
		System.out.println("teardown");
		projectService.deleteProjectById(p.getProjectId());
	}
	@Test
	void testGetAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		boolean returnStatment= false;
		for (Project project:projects) {
			if (p.toString().equals(project.toString())){
				returnStatment=true;
			}
		}
		assertTrue(returnStatment);
	}
	@Test
	void testGetProjectsByClientId() {
		List<Project> projects = projectService.getAllByClientId(clientid);
		boolean returnStatment= false;
		for (Project project:projects) {
			if (p.toString().equals(project.toString())){
				returnStatment=true;
			}
		}
		assertTrue(returnStatment);
	}
	@Test
	void testGetProjectById() {
		Project testProject = projectService.getProjectById(projectid);
		boolean returnStatment= false;

		if (p.toString().equals(testProject.toString())){
			returnStatment=true;
		}

		assertTrue(returnStatment);
	}
	@Test
	void testAddProject() {
		Project testProject = new Project(clientid,owner, teamLeads, null, "Test Project Add", "");
		testProject = projectService.addProject(testProject);

		Project getProject = projectService.getProjectById(testProject.getProjectId());
		boolean returnStatment= false;

		if (getProject.toString().equals(testProject.toString())){
			returnStatment=true;
		}

		projectService.deleteProjectById(testProject.getProjectId());
		assertTrue(returnStatment);
	}
	@Test
	void testUpdateProject() {
		String name = "updateProject";
		Project updateProject = new Project(projectid, clientid, /*owner,*/ teamLeads, null, name, "");

		projectService.updateProject(updateProject);

		Project getProject = projectService.getProjectById(p.getProjectId());

		assertEquals(name,getProject.getName());
	}
	@Test
	void testDisableProjectById() {

		projectService.disableProjectById(p.getProjectId());

		Project getProject = projectService.getProjectById(p.getProjectId());

		assertEquals(true,getProject.isDisabled());
	}

}
