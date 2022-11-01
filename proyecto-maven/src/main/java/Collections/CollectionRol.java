package Collections;

import java.util.ArrayList;
import java.util.List;

import elements.Persona;
import elements.Rol;
import Collections.CollectionPersonas;


public abstract class CollectionRol {
	public static List<Rol> roles;
	
	public static List<Rol> getRoles(){
		if(roles ==null){
			roles = new ArrayList<Rol>();
			roles.add(new Rol("ADMIN"));
			roles.add(new Rol("ADMIN"));	
		}
		return roles;
	}

	public static void agregarRol(Rol rol){
		roles.add(rol);
	}
	
//	public static Rol buscarRol(String email, String password){
//		Persona persona = null;
//		return rol;
//	}
	public static Persona buscarPersona(String email, String password){
		Persona persona = null;
		for(Persona per : personas) {
			per.getUsuario().getEmail().equals(email);//aca me falta
			per.getUsuario().getPassword().equals(password);//aca me falta
		}
		return persona;
	}
	
}
