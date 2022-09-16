package Logica;

import Logica.Espectaculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-09-16T17:19:58")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> descripcion;
    public static volatile SingularAttribute<Paquete, String> fechaI;
    public static volatile SingularAttribute<Paquete, Double> precio;
    public static volatile SingularAttribute<Paquete, String> fechaF;
    public static volatile SingularAttribute<Paquete, Double> descuento;
    public static volatile ListAttribute<Paquete, Espectaculo> espectaculos;
    public static volatile SingularAttribute<Paquete, String> nombre;

}