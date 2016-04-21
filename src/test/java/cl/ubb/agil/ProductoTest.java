package cl.ubb.agil;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class ProductoTest {
	
	
	@Test
	public void obtenerStock(){
	    Producto producto= new Producto("shampoo", 11, 15);
		int resultado=producto.getStock();
		assertThat(resultado,is(0));
			
	}
	
	@Test
	public void esBajoStockConStock0(){
		 Producto producto= new Producto("shampoo", 11, 15);
		 boolean resultado=producto.isBajoStock();
		 assertThat(resultado,is(true));
		// assertTrue(resultado);
	}
	@Test
	public void noEsBajoStockConStock12(){
		 Producto producto= new Producto("shampoo", 11, 15);
		 producto.stock=12;
		 boolean resultado=producto.isBajoStock();
		 assertThat(resultado,is(false));
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
	
	@Test
	
	public void añadirExistenciaStockMenorAStockMax(){
		Existencia existencias= new Existencia("5");
		Producto producto= new Producto("shampoo", 11, 15);
		boolean resultado=producto.addExistencia(existencias);
		assertThat(resultado,is(true));	
	}
	
	
	/* La prueba falla al momento en el que stock y el stock maximo son iguales, ya que deberia retornar 
	 * true pero esta lanza false*/
	@Test
	public void añadirExistenciaStockMayorAStockMax() throws ArrayIndexOutOfBoundsException{
		Existencia existencias= new Existencia("5");
		Producto producto= new Producto("shampoo", 11, 15);
		producto.stock=16;
		boolean resultado=producto.addExistencia(existencias);
		assertThat(resultado,is(false));	
	}
	
	
	@Test
	public void obtenerCategoria(){
		Categoria categoria=new Categoria("baño","02");
		Producto producto= new Producto("shampoo", 11, 15,categoria);
		Categoria resultado=producto.getCategoria(); 
		assertThat(resultado,is(categoria));
		
	}
	
	@Test 
	public void asignarCategoria(){
		Categoria categoria=new Categoria(""," 02");
		Producto producto= new Producto("shampoo", 11, 15,categoria);
		producto.setCategoria(categoria);
		Categoria resultado=producto.getCategoria();
		assertThat(resultado,is(categoria));	
	}
	
	@Test
	public void obtenerNombre(){
		Producto producto= new Producto("shampoo", 11, 15);
		String resultado=producto.getNombre();
		assertThat(resultado,is("shampoo"));
		
	}
	
	@Test
	public void asignarNombre(){
		Producto producto= new Producto("", 11, 15);
		producto.setNombre("acondicionador");
		String resultado=producto.getNombre();
		assertThat(resultado,is("acondicionador"));	
	}
	
	@Test 
	public void obtenerProxExistenciaConStockMayorA0yCategoria() throws ExcepcionDeProducto{
		Existencia existencia=new Existencia("1");
		Categoria categoria= new Categoria("baño", "02");
		Producto producto= new Producto("shampoo", 11, 15,categoria);
		producto.addExistencia(existencia);
		String resultado=producto.getCodigoProximaExistencia();
		assertThat(resultado,is("02-1"));
	}
	
	@Test
	public void obtenerProxExistenciaConStockMayotA0yCategoriaNull() throws ExcepcionDeProducto{
		Existencia existencia=new Existencia("1");
		Producto producto= new Producto("shampoo", 11, 15,null);
		producto.addExistencia(existencia);
		String resultado=producto.getCodigoProximaExistencia();
		assertThat(resultado,is("XXXXX-1"));
		
	}
	
	@Test (expected=ExcepcionDeProducto.class)
	public void obtenerProxExistenciaStockMenos0() throws ExcepcionDeProducto{
		Categoria categoria= new Categoria("baño", "02");
		Producto producto= new Producto("shampoo", 11, 15,categoria);
		String resultado=producto.getCodigoProximaExistencia();
	}
	

	
}
