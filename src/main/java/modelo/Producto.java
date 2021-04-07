package modelo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Builder
@Data
public class Producto {

  //ID indica que es la PK de la base
  @Id
  //Indica que es aun valor autogenerado de forma automatica-
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo;

  private String nombre;

  private Double precio;

  private String categoria;




}
