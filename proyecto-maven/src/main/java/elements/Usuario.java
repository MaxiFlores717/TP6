package elements;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Usuario {
	private String email;
	private String password;
	private boolean estado;
	private LocalDate fechaAlta;
	private Rol rol;
	
	
	
	public Usuario(String email, String password, boolean estado, LocalDate fechaAlta, Rol rol) {
		super();
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.fechaAlta = fechaAlta;
		this.rol = rol;
	}
	public Usuario() {
		super();
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
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public boolean verificarRolDuracion() {
		boolean aux = true;
		LocalDate s= LocalDate.of(2020, Month.MARCH, 28);
		
		int diferencia = (int) ChronoUnit.DAYS.between(s, this.fechaAlta);
		if(diferencia <= this.rol.getDuracionRol()) {
			aux=false;
			this.setEstado(false);
		}
		return aux;
	}
	
	
}
