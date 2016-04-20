package cl.ubb.agil;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ProductoTest {
	private Producto producto= new Producto("shampoo", 11, 15);	
	//private Categoria categoria=new Categoria("baño"," 02");
	@Test
	public void stockIgual10(){
		producto.stock=10;
		int resultado=producto.getStock();
		assertThat(resultado,is(10));
			
	}
	
	@Test
	public void esBajoStockPor1(){
		producto.isBajoStock();
		
	}
	
}
