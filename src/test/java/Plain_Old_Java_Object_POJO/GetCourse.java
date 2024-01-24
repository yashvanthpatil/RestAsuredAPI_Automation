package Plain_Old_Java_Object_POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCourse 
{
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Plain_Old_Java_Object_POJO.Courses getCourses() {
		return Courses;
	}
	public void setCourses(Plain_Old_Java_Object_POJO.Courses courses) {
		Courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedin) {
		this.linkedIn = linkedin;
	}
	private String url;
	private String services;
	private String expertise;
	private Courses Courses; // integrated with nested json 
	private String instructor;
	private String linkedIn;
	
// create the getters and setters for the response
}
