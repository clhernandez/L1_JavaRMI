package cl.usach.lab1.finanzas.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitIntranetAction extends ActionSupport{
	private String email;
	
	public String execute() throws Exception {
		Map sesion = ActionContext.getContext().getSession();
		email = (String) sesion.get("email");
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
