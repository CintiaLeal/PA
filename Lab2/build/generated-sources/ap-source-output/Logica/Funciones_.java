package Logica;

import Logica.Registro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-09-16T17:19:58")
@StaticMetamodel(Funciones.class)
public class Funciones_ { 

    public static volatile SingularAttribute<Funciones, String> fecha;
    public static volatile SingularAttribute<Funciones, String> hora;
    public static volatile SingularAttribute<Funciones, String> fechaRegistro;
    public static volatile ListAttribute<Funciones, Registro> registros;
    public static volatile SingularAttribute<Funciones, String> nombre;

}