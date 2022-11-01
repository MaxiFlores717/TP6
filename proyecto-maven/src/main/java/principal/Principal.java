package principal;

import java.time.LocalDate;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import Collections.CollectionPersonas;
import Collections.CollectionRol;
import elements.Persona;
import elements.Rol;
import elements.Usuario;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String a;
//		boolean bandera;
//		do {
//			try {
//				bandera = true;
//				System.out.println("Ingrese edad: "	);
//				int edad = teclado.nextInt();
//				
//			}catch(InputMismatchException ime) {
//				bandera = false;
//				System.out.println("debe ingresar un valor numerico entero.....");
//				teclado.next();
//			}
//			
//		}while(bandera==false);
//		
//		System.out.println("continuamos ");
//	
		int opc= 0; {
			do {
				System.out.println("-------Menu de opciones-------");
				System.out.println("1)Iniciar Sesion");
				System.out.println("2)Salir");
				opc = teclado.nextInt();
				switch(opc) {
				case 1:
					System.out.println("Ingrese EMAIL:");
					String email = teclado.next();
					System.out.println("Ingrese Password:");
					String password = teclado.next();
					if(CollectionPersonas.verificarCredenciales(email, password) == true) {
						Persona persona;
						persona = CollectionPersonas.buscarPersona(email, password);
						if(persona.getUsuario().getRol().getDescripcion()=="ADMIN") {
							System.out.println("-------Menu Admin-------");
							System.out.println("1)Alta Persona");
							System.out.println("2)Buscar un usuario por email y mostrar datos");
							opc=teclado.nextInt();
							switch(opc) {
							case 1:
								System.out.println("Ingrese Nombre de la persona");
								String nombre = teclado.next();
								System.out.println("Ingrese Apellido de la persona");
								String apellido = teclado.next();
								System.out.println("Ingrese Dni de la persona");
								Long dni = teclado.nextLong();
								Usuario usuario = new Usuario();
								System.out.println("Ingrese Email para el usuario de la usuario");
								String email1 = teclado.next();
								usuario.setEmail(email1);
								System.out.println("Ingrese Password del usuario");
								String password1 = teclado.next();
								System.out.println("Ingrese el rol del usuario");
								System.out.println("1)ADMIN");
								System.out.println("2)CLIENTE");
								opc = teclado.nextInt();
								switch(opc) {
								case 1:
									Rol rol1 = new Rol("ADMIN");
									Usuario usuario1 = new Usuario(email, password, true, LocalDate.of(2022, 10, 1) ,rol1);
									Persona persona1 = new Persona(nombre, apellido, dni, usuario1);
									CollectionPersonas.agregarPersona(persona1);	
									break;
								case 2:
									Rol rol2 = new Rol("CLIENTE");
									Usuario usuario2 = new Usuario(email, password, true, LocalDate.of(2022, 10, 1) ,rol2);
									Persona persona2 = new Persona(nombre, apellido, dni, usuario2);
									CollectionPersonas.agregarPersona(persona2);
									break;
								}
								
								break;
							case 2:
								System.out.println("Ingrese el email del usuario a buscar:");
								String email3 = teclado.next();
								Persona person=CollectionPersonas.buscarPersonaPorEmail(email3);
								System.out.println(person);
								break;
							}
							}
						}
					}
					
					break;
				}		
			}while (opc != 4);
	}

}
