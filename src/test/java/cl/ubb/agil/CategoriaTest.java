package cl.ubb.agil;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CategoriaTest {

	@Test
	
	public void obtenerElNombreCategoria(){
		Categoria categoria=new Categoria("baño"," 02");
		String resultado= categoria.getNombre();
		assertThat(resultado,is("baño"));
	}
	
	public void asignarNombre(){
		
	}
	
	@Test
	public void obtenerCodigoLargoMenorA5(){
		Categoria categoria=new Categoria("baño","02");
		String resultado= categoria.getCodigo();
		assertThat(resultado,is("02"));
	}
	
	@Test
	public void obtenerCodigoLargoMayorA5(){
		Categoria categoria=new Categoria("baño","012345");
		String resultado= categoria.getCodigo();
		assertThat(resultado,is("01234"));
	}
	
	@Test 
	
	public void asignarCodigo(){
		
	}
	
	
}
