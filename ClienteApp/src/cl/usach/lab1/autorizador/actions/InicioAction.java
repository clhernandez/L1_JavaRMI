package cl.usach.lab1.autorizador.actions;

import java.util.Map;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InicioAction extends ActionSupport {
	private static final long serialVersionUID = -8951789420409184895L;
	private String email;
	protected String password;

	public String execute() throws Exception {
		ClienteRrhhRMI autorizadorRMI = new ClienteRrhhRMI();
		Trabajador trabajador = autorizadorRMI.loginUsuario(email, password);
		if (trabajador!=null) {
			// Inicio de sesion satisfactorio asignar valores
			Map session = ActionContext.getContext().getSession();
			session.put("logedIn", "true");
			session.put("email", email);
			session.put("nombre", trabajador.getNombre());
			session.put("apellido", trabajador.getApellido());
			return "RRHH";
		}
		return ERROR;

	}
	
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("logedIn");
		session.remove("email");
		return SUCCESS;
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
