package Logica;

import Logica.Espectaculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-09-16T17:19:58")
@StaticMetamodel(Plataforma.class)
public class Plataforma_ { 

    public static volatile SingularAttribute<Plataforma, String> descripcion;
    public static volatile ListAttribute<Plataforma, Espectaculo> espectaculos;
    public static volatile SingularAttribute<Plataforma, String> nombre;
    public static volatile SingularAttribute<Plataforma, Espectaculo> es;
    public static volatile SingularAttribute<Plataforma, String> url;

}