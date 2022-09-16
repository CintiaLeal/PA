
package pkgWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pkgWS package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ParseException_QNAME = new QName("http://complejoservidor/", "ParseException");
    private final static QName _FileNotFoundException_QNAME = new QName("http://complejoservidor/", "FileNotFoundException");
    private final static QName _DocumentException_QNAME = new QName("http://complejoservidor/", "DocumentException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pkgWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DocumentException }
     * 
     */
    public DocumentException createDocumentException() {
        return new DocumentException();
    }

    /**
     * Create an instance of {@link FileNotFoundException }
     * 
     */
    public FileNotFoundException createFileNotFoundException() {
        return new FileNotFoundException();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link ListPlataforma }
     * 
     */
    public ListPlataforma createListPlataforma() {
        return new ListPlataforma();
    }

    /**
     * Create an instance of {@link Espectaculo }
     * 
     */
    public Espectaculo createEspectaculo() {
        return new Espectaculo();
    }

    /**
     * Create an instance of {@link Premio }
     * 
     */
    public Premio createPremio() {
        return new Premio();
    }

    /**
     * Create an instance of {@link DtEspectaculo }
     * 
     */
    public DtEspectaculo createDtEspectaculo() {
        return new DtEspectaculo();
    }

    /**
     * Create an instance of {@link Espectador }
     * 
     */
    public Espectador createEspectador() {
        return new Espectador();
    }

    /**
     * Create an instance of {@link DtBusqueda }
     * 
     */
    public DtBusqueda createDtBusqueda() {
        return new DtBusqueda();
    }

    /**
     * Create an instance of {@link ListString }
     * 
     */
    public ListString createListString() {
        return new ListString();
    }

    /**
     * Create an instance of {@link ListBusqueda }
     * 
     */
    public ListBusqueda createListBusqueda() {
        return new ListBusqueda();
    }

    /**
     * Create an instance of {@link Paquete }
     * 
     */
    public Paquete createPaquete() {
        return new Paquete();
    }

    /**
     * Create an instance of {@link Puntaje }
     * 
     */
    public Puntaje createPuntaje() {
        return new Puntaje();
    }

    /**
     * Create an instance of {@link DtFunciones }
     * 
     */
    public DtFunciones createDtFunciones() {
        return new DtFunciones();
    }

    /**
     * Create an instance of {@link EspectaculoCategoria }
     * 
     */
    public EspectaculoCategoria createEspectaculoCategoria() {
        return new EspectaculoCategoria();
    }

    /**
     * Create an instance of {@link DtArtista }
     * 
     */
    public DtArtista createDtArtista() {
        return new DtArtista();
    }

    /**
     * Create an instance of {@link DtPaquetes }
     * 
     */
    public DtPaquetes createDtPaquetes() {
        return new DtPaquetes();
    }

    /**
     * Create an instance of {@link Artista }
     * 
     */
    public Artista createArtista() {
        return new Artista();
    }

    /**
     * Create an instance of {@link Categoria }
     * 
     */
    public Categoria createCategoria() {
        return new Categoria();
    }

    /**
     * Create an instance of {@link ListPaquete }
     * 
     */
    public ListPaquete createListPaquete() {
        return new ListPaquete();
    }

    /**
     * Create an instance of {@link DtEspectador }
     * 
     */
    public DtEspectador createDtEspectador() {
        return new DtEspectador();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link DtPlataforma }
     * 
     */
    public DtPlataforma createDtPlataforma() {
        return new DtPlataforma();
    }

    /**
     * Create an instance of {@link Registro }
     * 
     */
    public Registro createRegistro() {
        return new Registro();
    }

    /**
     * Create an instance of {@link Funciones }
     * 
     */
    public Funciones createFunciones() {
        return new Funciones();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://complejoservidor/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://complejoservidor/", name = "FileNotFoundException")
    public JAXBElement<FileNotFoundException> createFileNotFoundException(FileNotFoundException value) {
        return new JAXBElement<FileNotFoundException>(_FileNotFoundException_QNAME, FileNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://complejoservidor/", name = "DocumentException")
    public JAXBElement<DocumentException> createDocumentException(DocumentException value) {
        return new JAXBElement<DocumentException>(_DocumentException_QNAME, DocumentException.class, null, value);
    }

}
