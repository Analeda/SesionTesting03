package cl.ubb.agil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExistenciaTest {

	@Test
	public void obtenerNumero(){
		Existencia existencia= new Existencia("3");
		String resultado=existencia.getNumero();
		assertThat(resultado, is("3"));
	}
	
	
}
