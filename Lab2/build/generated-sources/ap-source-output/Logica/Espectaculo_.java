package Logica;

import DataType.Estado;
import Logica.Artista;
import Logica.Espectaculo_Categoria;
import Logica.Funciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-09-16T17:19:58")
@StaticMetamodel(Espectaculo.class)
public class Espectaculo_ { 

    public static volatile SingularAttribute<Espectaculo, String> descripcion;
    public static volatile SingularAttribute<Espectaculo, Artista> a;
    public static volatile SingularAttribute<Espectaculo, Estado> estado;
    public static volatile ListAttribute<Espectaculo, Funciones> funciones;
    public static volatile SingularAttribute<Espectaculo, Double> costo;
    public static volatile SingularAttribute<Espectaculo, String> fechaRegistro;
    public static volatile ListAttribute<Espectaculo, Espectaculo_Categoria> categorias;
    public static volatile SingularAttribute<Espectaculo, Integer> duracion;
    public static volatile SingularAttribute<Espectaculo, Integer> cantMinEsp;
    public static volatile SingularAttribute<Espectaculo, String> nombre;
    public static volatile SingularAttribute<Espectaculo, Integer> cantMaxEsp;

}