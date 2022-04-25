package poo1.colegio.fachada;

import poo1.colegio.base.Candidato;
import poo1.colegio.base.Personero;
import poo1.colegio.base.Representante;

public class Colegio {
	
	private int numeroVotosBlanco;
	private int cont;

	private Candidato[] candidatos;
	
	public Colegio(int tamanio) {
		candidatos = new Candidato[tamanio];
	}
	
	public void agregarCandidatoPersonero(String nombre, String apellido, 
			String grado, String lema, int numeroTarjeton, String idMascota, 
			String nombreMascota) {
		
		Personero p = new Personero();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setGrado(grado);
		p.setLema(lema);
		p.setNumeroTarjeton(numeroTarjeton);
		
		p.setMascota(idMascota, nombreMascota);
		
		if(!repiteNumeroTarjeton(numeroTarjeton)) {		
			if(cont<candidatos.length) {
				candidatos[cont] = p;
				cont++;
			}
		}else
			System.err.println(nombre + " " + apellido + 
					" no se puede agregar con el tarjetón " + 
					numeroTarjeton + ".\nYa existe un candidato con ese número");
		
	}
	
	public void agregarCandidatoRepresentante(String nombre, String apellido, 
			String grado, String grupo, String lema, int numeroTarjeton, String formula) {
		
		Representante p = new Representante();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setGrado(grado);
		p.setGrupo(grupo);
		p.setLema(lema);
		p.setNumeroTarjeton(numeroTarjeton);
		p.setNombreFormulaEstudiante(formula);
		
		if(!repiteNumeroTarjeton(numeroTarjeton)) {
			if(cont<candidatos.length) {
				candidatos[cont] = p;
				cont++;
			}
		}else
			System.err.println(nombre + " " + apellido + 
					" no se puede agregar con el tarjetón " + 
					numeroTarjeton + ".\nYa existe un candidato con ese número");
		
	}
	
	public void agregarVoto(int numeroTarjeton) {
		
		for(int t=0;t<candidatos.length;t++) {
			Candidato c = candidatos[t];
			if(c!=null) {
				if(c.getNumeroTarjeton()==numeroTarjeton) {
					c.setVotos(c.getVotos()+1);
					return;
				}
			}
		}
		
	}
	
	public void agregarVotoBlanco() {
		numeroVotosBlanco++;
	}
	
	public void imprimirVotosPorCandidato() {
		for(int t=0;t<candidatos.length;t++) {
			Candidato c = candidatos[t];
			if(c!=null) {
				System.out.println(c.getApellido() + ", " + c.getNombre() + 
					" (" + c.getClass().getName() + ") = " + 
					c.getVotos() + " votos.");
			}
		}
	}
	
	public void imprimirCandidatosGanadores() {
		int maxVotosPersonero = 0;
		int maxVotosRepresentante = 0;
		
		String nombreCompletoPersoneroGanador = "";
		String nombreCompletoRepresentanteGanador = "";
		
	
		for(int t=0;t<candidatos.length;t++) {
			Candidato c = candidatos[t];
			if(c!=null) {
				// Para sacar los personeros
				if(c instanceof Personero) {
					if(maxVotosPersonero<c.getVotos()) {
						maxVotosPersonero = c.getVotos();
						nombreCompletoPersoneroGanador = c.getNombre() + " " + c.getApellido();
					}
				}
				// Para sacar los representantes
				if(c instanceof Representante) {
					if(maxVotosRepresentante<c.getVotos()) {
						maxVotosRepresentante = c.getVotos();
						nombreCompletoRepresentanteGanador = c.getNombre() + " " + c.getApellido();
					}
				}
			}			
		}
		
		System.out.println("Personero: " + nombreCompletoPersoneroGanador + "(" + maxVotosPersonero + " votos)");
		System.out.println("Representante: " + nombreCompletoRepresentanteGanador + "(" + maxVotosRepresentante + " votos)");
		
	}
	
	public void imprimirPoblacionElectoral() {
		imprimirVotosPorCandidato();
		System.out.println("En Blanco = " + numeroVotosBlanco + " votos.");
	}
	
	private boolean repiteNumeroTarjeton(int numeroTarjeton) {
		for(int t=0;t<candidatos.length;t++) {
			Candidato c = candidatos[t];
			if(c!=null) {
				if(c.getNumeroTarjeton()==numeroTarjeton) {
					return true;
				}
			}
		}
		return false;
	}
	
}
