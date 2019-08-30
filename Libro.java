
package ucvBiblio;

public class Libro {
     //LAS PROPIEDADES 
     //LAS PROPIEDADES 
    private int nroRegistro;
    private String CodigoLibro;
    private String Titulo;
    private String Autor;
    private String Editorial;
    private int Aniodeedicion;
    private String FechaDevolucion;
    private String Estado;
   
    //EL CONSTRUCTOR
    public Libro(){}

    public Libro(int nroRegistro,String CodigoLibro, String Titulo, String Autor, String Editorial,
            int Aniodeedicion,String FechaDevolucion, String Estado) {
        this.nroRegistro=nroRegistro;
        this.CodigoLibro = CodigoLibro;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.Aniodeedicion = Aniodeedicion;
        this.Estado=Estado;
    }
     //GETTERS Y SETTERS

    public int getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(int nroRegistro) {
        this.nroRegistro = nroRegistro;
    }
       
    public String getCodigoLibro() {
        return CodigoLibro;
    }

    public void setCodigoLibro(String CodigoLibro) {
        this.CodigoLibro = CodigoLibro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public int getAniodeedicion() {
        return Aniodeedicion;
    }

    public void setAniodeedicion(int Aniodeedicion) {
        this.Aniodeedicion = Aniodeedicion;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
 }
