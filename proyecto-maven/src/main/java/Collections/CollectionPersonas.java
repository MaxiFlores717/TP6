package Collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import elements.Persona;
import elements.Usuario;

public abstract class CollectionPersonas {
	public static List<Persona> personas;
	
	public static List<Persona> getPersonas(){
		if(personas ==null){
			CollectionRol.getRoles();
			personas = new ArrayList<Persona>();
			Usuario us = new Usuario("jperez@mail.com", "123", true, LocalDate.of(2022, 10, 1),CollectionRol.roles.get(0));
			Persona per = new Persona("Juan", "Perez", 20130466, us);
			personas.add(per);	
		}
		return personas;
	}

	public static void agregarPersona(Persona persona){
		personas.add(persona);
	}
	
	public static Persona buscarPersona(String email, String password){
		Persona persona = null;
		for(Persona per : personas) {
			per.getUsuario().getEmail().equals(email);//aca me falta
			per.getUsuario().getPassword().equals(password);//aca me falta
		}
		return persona;
	}
	
	public static boolean verificarCredenciales(String email, String password) {
		Persona verificarCredenciales = null;
		boolean aux = false;
		try {
			verificarCredenciales = personas.stream().filter(e -> e.getUsuario().getEmail() == email).findFirst().get();
			verificarCredenciales = personas.stream().filter(e -> e.getUsuario().getPassword() == password).findFirst().get();			
		}
		catch(Exception e) {
			System.out.println("El usuario no existe");
			aux = true;
		}
		return aux;	
	}
	
	public static Persona buscarPersonaPorEmail(String email) {
		Persona buscarPersonaPorEmail = null;
		try {
			buscarPersonaPorEmail= personas.stream().filter(e -> e.getUsuario().getEmail() == email).findFirst().get();
		}
		catch(Exception e) {
			System.out.println("El usuario no existe");
		}
		return buscarPersonaPorEmail;	
	}

}
