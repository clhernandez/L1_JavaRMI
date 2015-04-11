package cl.usach.lab1.finanzas.actions;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InicioAction extends ActionSupport {
	private String email;
	protected String password;

	public String execute() throws Exception {
		if (email.equals("") || password.equals("")) {
			return ERROR;
		}else {
			//Inicio de sesion satisfactorio asignar valores
			Map session = ActionContext.getContext().getSession();
			session.put("logedIn", "true");
			session.put("ultimoLogin", new Date());
			session.put("email", email);
			return SUCCESS;
		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
