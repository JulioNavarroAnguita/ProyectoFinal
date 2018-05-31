package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class LeerCSV {

	private static List<PeliculaDTO> listaPeliculas = new ArrayList<>();


	public List<PeliculaDTO> getListaPeliculas() {
		return listaPeliculas;
	}

	public LeerCSV(String fichero) {
		cargarDatosFichero(fichero);
	}

	//metodo para cargar datos pasandole como argumento un fichero
	public void cargarDatosFichero(String fichero) {

		//Utilizando la clase externa CSVReader


		try (CSVReader csvReader = new CSVReader(new FileReader(fichero));){

			String[] datosCsv = csvReader.readNext();
			while((datosCsv = csvReader.readNext()) != null) {

				listaPeliculas.add(new PeliculaDTO(datosCsv[0], datosCsv[1], datosCsv[2], 
						datosCsv[3]));
			}
			
			//System.out.println(listaPeliculas);
		} catch (IOException | ExceptionPelicula e) {

		}


	}
}

