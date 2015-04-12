package cl.usach.lab1.autorizador.actions;

import java.util.Date;
import java.util.Map;

import cl.usach.lab1.autorizador.client.ClienteAutorizadorRMI;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InicioAction extends ActionSupport {
	private static final long serialVersionUID = -8951789420409184895L;
	private String email;
	protected String password;

	public String execute() throws Exception {
		ClienteAutorizadorRMI autorizadorRMI = new ClienteAutorizadorRMI();
		
		if (autorizadorRMI.loginUsuario(email, password)) {
			// Inicio de sesion satisfactorio asignar valores
			Map session = ActionContext.getContext().getSession();
			session.put("logedIn", "true");
			session.put("ultimoLogin", new Date());
			session.put("email", email);
			return SUCCESS;
		}
		return ERROR;

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
