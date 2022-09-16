package persistencia;

import java.util.logging.Level;
import java.util.logging.Logger;
import Logica.Artista;
import Logica.Espectaculo;
import Logica.Plataforma;
import Logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;


public class controlador {
    
    PlataformaJpaController plataformaJpa = new PlataformaJpaController ();
    
    EspectaculoJpaController espJpa = new EspectaculoJpaController();
    
    ArtistaJpaController artistaJpa = new ArtistaJpaController();
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    
    public void crearPlataforma (Plataforma p) throws Exception {
        plataformaJpa.create(p);
    }
    
    public void agregarEspectaculo(Plataforma p, Espectaculo e) throws Exception{
        plataformaJpa.agregarEspectaculo(p,e);
    }
    
    
    public void borrarPlataforma (String id){
    
        try {
            plataformaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void crearEspectaculo (Espectaculo e) throws Exception {
        espJpa.create(e);
    
    }
    
    public void crearArtista (Artista a) throws Exception{
        artistaJpa.create(a);
    
    }
    
     public void crearUsuario (Usuario u) throws Exception{
        usuarioJpa.create(u);
    
    }
    
}
    

