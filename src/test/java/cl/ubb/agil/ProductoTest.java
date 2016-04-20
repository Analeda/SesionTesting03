package cl.ubb.agil;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class ProductoTest {
	
	
	//private Producto producto= new Producto("shampoo", 11, 15);	
	//private Categoria categoria=new Categoria("baño"," 02");
	
	@Test
	public void obtenerStock(){
	    Producto producto= new Producto("shampoo", 11, 15);
		int resultado=producto.getStock();
		assertThat(resultado,is(producto.getStock()));
			
	}
	
	@Test
	public void esBajoStockConStock0(){
		 Producto producto= new Producto("shampoo", 11, 15);
		 boolean resultado=producto.isBajoStock();
		 assertThat(resultado,is(true));
		// assertTrue(resultado);
	}
	
	@Test
	
	public void obtenerStockFaltanteConStock0(){
		Producto producto= new Producto("shampoo", 11, 15);
		int resultado= producto.getStockFaltante();
		assertThat(resultado,is(15));
		
	}
	
	@Test 
	
	public void obtenerProximaExistenciaConStockMayorA0() throws ExcepcionDeProducto{
		Producto producto= new Producto("shampoo", 11, 15);
		producto.stock=9;
		Existencia resultado= producto.getProximaExistencia();
		assertThat(resultado, nullValue());		
	}
	
	@Test (expected=ExcepcionDeProducto.class)
	public void obtenerProximaExistenciaConStockMenorA0() throws ExcepcionDeProducto{
		Producto producto= new Producto("shampoo", 11, 15);
		producto.stock=-9;
		Existencia resultado= producto.getProximaExistencia();	
	}
	
	
}
