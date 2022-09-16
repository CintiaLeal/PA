package Logica;

import Logica.Espectador;
import Logica.Funciones;
import Logica.Registro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-09-16T17:19:58")
@StaticMetamodel(Registro.class)
public class Registro_ { 

    public static volatile SingularAttribute<Registro, String> fecha;
    public static volatile SingularAttribute<Registro, Funciones> funciones;
    public static volatile ListAttribute<Registro, Registro> registros;
    public static volatile SingularAttribute<Registro, Espectador> espectador;
    public static volatile SingularAttribute<Registro, Integer> id;

}