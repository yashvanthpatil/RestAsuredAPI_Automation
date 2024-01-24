package Plain_Old_Java_Object_POJO;

import java.util.List;

public class Courses {
	
	
	public List<Plain_Old_Java_Object_POJO.webAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<Plain_Old_Java_Object_POJO.webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	private List<webAutomation> webAutomation;
	private List<Api> api;
	private List<Mobile> mobile;

}
