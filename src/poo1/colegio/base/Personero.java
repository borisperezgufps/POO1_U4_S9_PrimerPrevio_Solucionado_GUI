package poo1.colegio.base;

public class Personero extends Candidato {

	private Mascota mascota;

	public String getIdentificacionMascota() {
		if(mascota!=null)
			return mascota.getIdentificacion();
		
		return null;
	}
	
	public String getNombreMascota() {
		if(mascota!=null)
			return mascota.getNombre();
		
		return null;
	}

	public void setMascota(String id, String nombre) {
		mascota = new Mascota();
		mascota.setIdentificacion(id);
		mascota.setNombre(nombre);
	}
	
}
