package modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Data

public class Vendedor {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer codigo;

  String nombre;

  Double sueldo;

  private int productosVendidos;
  private int ganancias;


  @ManyToMany List<Producto> productoList;


  public void addProducto(Producto p) {
    this.productoList.add(p);
  }
  @Builder
  public Vendedor(String nombre, double sueldo){
    this.productoList = new ArrayList<>();
    this.nombre=nombre;
    this.sueldo=sueldo;
  }
  public List<Producto> venderProducto(Producto p){
    if (productoList.contains(p)){
      productosVendidos++;
      ganancias+=p.getPrecio();
      productoList.remove(p);
    }
    return this.productoList;
  }

  public double calcularComision() { //Calcula la comision por ventas
    if(productosVendidos>2) {
      return ganancias*0.10;
    }else {
      return ganancias*0.05;
    }
  }

}
