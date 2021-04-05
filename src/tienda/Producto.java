package tienda;

public class Producto {
	
	private int codigo;
	private String nombre;
	private int precio;
	private String categoria;
	private Vendedor vendedor;
	
	public Producto(int codigo, String nombre, int precio, String categoria,Vendedor v) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.vendedor=v;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public Vendedor getVendedor() {
		return this.vendedor; 
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Producto p = (Producto) o;
			return this.getCodigo() == p.getCodigo();
		}catch(Exception exc){
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.getNombre();
	}

}