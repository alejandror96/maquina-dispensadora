package Modelo;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

import Controlador.ControladorEspirales;

public class AdministradorEspirales {
	
	int capacidadMaxima = 15;
	Espiral datosEspiral;
	Espiral espiral = new Espiral();
	
	public String mostrarEspirales() {
		File fichero = new File("productos.txt");
		Scanner s = null;
		String auxiliarParaMostrar = "";
		try {
			s = new Scanner(fichero);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				auxiliarParaMostrar = auxiliarParaMostrar + linea + "\n";
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, auxiliarParaMostrar);
		return auxiliarParaMostrar;
	}
	
	public void mostrarInformacionProducto(){
		
		ControladorEspirales controladorEspiral = new ControladorEspirales();
		JOptionPane.showMessageDialog(null, "algo");
	}

	public Boolean verificarContenidoEnEspiral() {
		Boolean auxiliarVerificacionContenidoEspiral = false;	
		while(auxiliarVerificacionContenidoEspiral == false){		
			if (espiral.getCantidad()>1){
				auxiliarVerificacionContenidoEspiral = true;
			}else{
				JOptionPane.showMessageDialog(null, "El producto deseado no posee existencias", "Error", JOptionPane.ERROR_MESSAGE);
				auxiliarVerificacionContenidoEspiral = false;
			}
		}
		return auxiliarVerificacionContenidoEspiral;
		
	}

	String auxiliarLinea = "";
	public void conocerLineaDondeEstaElProducto(String codigo) {
		File fichero = new File("productos.txt");
		Scanner s = null;
		try {
			s = new Scanner(fichero);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				if (linea.contains(codigo)){
					auxiliarLinea = linea;	
				}
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Algo"+auxiliarLinea);
		darValoresAEspiral();
	}
	
	public void darValoresAEspiral(){
		String[] datosEspiral= auxiliarLinea.split(",");
		espiral.setCodigo(datosEspiral[0]);
		espiral.setProducto(datosEspiral[1]);
		espiral.setCantidad(Integer.parseInt(datosEspiral[2]));
		espiral.setPrecioProducto(Integer.parseInt(datosEspiral[3]));
		JOptionPane.showMessageDialog(null, "Producto"+espiral.getCantidad());
	}

}