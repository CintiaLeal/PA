
package pkgWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtPaquetes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtPaquetes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPaquetes")
public class DtPaquetes {
private String nombre;
 private String descripcion;
 private String fechaInicio;
 private  String fechaFin;
 private  String fechaAlta;
 private Double precio;
 private Double descuento;
 private String img;
    public DtPaquetes(String nombre, String descripcion, String fechaInicio, String fechaFin,String fechaAlta, Double precio, Double descuento,String i) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaAlta = fechaAlta;
        this.precio = precio;
        this.descuento = descuento;
        this.img = i;
    }

    public DtPaquetes() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    public String getImg() {
        return img;
    }


}
