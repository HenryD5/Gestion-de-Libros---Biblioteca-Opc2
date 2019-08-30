
package ucvBiblio;
//Importando Scanner y El ArrayList 
import java.util.ArrayList;
import java.util.Scanner;
public class Biblioteca {
    //PROPIEDADES
    private static Scanner Leer;        
    private static ArrayList<Libro> DatosLibro;
    private static Libro oLibro;
    public static void main(String[] args) {
        Leer = new Scanner(System.in);
        DatosLibro= new ArrayList();
        oLibro = new Libro();
        int Op;
        do{
            Op = Menu();
            switch(Op){
                case 1:
                        IngresodeLibro();
                    break;
                case 2:
                        Movimientos();
                    break;
                case 3:
                        Disponibilidad();
                    break;
                case 4:
                        ModificarLibro();
                    break;
                case 5:
                        EliminarLibro();
                    break;
                case 6:
                        ListarLibros();
                    break;
                case 7:
                    System.out.println("**************************************");
                    System.out.println("(>>> GRACIAS USAR LA BIBLIOTECA <<<)");
                    System.out.println("**************************************");
                    break;
        
                default: 
                    System.out.println("*************************");
                    System.out.println("(>OPCION INVALIDA<)");
                    System.out.println("***********************");        
            }
        }while(Op!= 7);
        
    }
    public static int Menu(){
        // Menu
        System.out.println("<<<< MENÚ DE OPCIONES>>>>");
        System.out.println("<><><><><><><><><><><><><>");
        System.out.println(" 1. Ingresar Libro ");
        System.out.println(" 2. Movimientos");
        System.out.println(" 3. Disponibilidad del libro");
        System.out.println(" 4. Modificar Datos de Libro ");
        System.out.println(" 5. Eliminar Libro");
        System.out.println(" 6. Listado");
        System.out.println(" 7. Terminar");
        System.out.print("<<Elija su Opcion Preferida(1-7)>> : ");
        return Leer.nextInt(); 
    }
    
    //MENU 1: INGRESAR LIBRO
     public static void IngresodeLibro(){
        String codlibro,titulolibro,autor,editorial,estado;
        int numlibro,aniodeedicion;
         
        String opcion="";
        while(!opcion.equals("N")){
        //Obteniendo el numero de registro 
        numlibro=DatosLibro.size()+1;
        System.out.println("\n\n** REGISTRO DE LIBRO N° "+numlibro+"**");       
        System.out.println("INGRESE EL CÓDIGO DEL LIBRO: ");
        System.out.print("°°  ");
        codlibro = Leer.next();
        //Validar Que no se registre duplicado de CodigoLibro
        while(validarCodigo(codlibro)==1){
           System.out.println("CODLIBRO ya está REGISTRADO. Ingrese uno NUEVO.");
           System.out.println("INGRESE EL CÓDIGO DEL LIBRO: ");
           System.out.print("°°  ");
           codlibro = Leer.next();  
        }
        System.out.println("INGRESE EL TITULO DEL LIBRO: ");
        System.out.print("°°  ");
        titulolibro= Leer.next();
        System.out.println("INGRESE EL NOMBRE DE LA EDITORIAL AL QUE PERTENECE EL LIBRO: ");
        System.out.print("°°  ");
        editorial= Leer.next();
        System.out.println("INGRESE EL NOMBRE DEL AUTOR : ");
        System.out.print("°°  ");
        autor= Leer.next();
        System.out.println("INGRESE EL AÑO DE EDICIÒN DEL LIBRO(mayor de 1900 y menor al 2017): ");
        System.out.print("°°  ");
        aniodeedicion= Leer.nextInt();
        //Validando el anio de edicion - Se convierte a String el Int para contar que sea igual a 4 caracteres
        while(!(aniodeedicion>1900 && aniodeedicion<2017 && Integer.toString(aniodeedicion).length()==4)){
            System.out.println("Año no válido.Intente de nuevo"); 
            System.out.println("INGRESE EL AÑO DE EDICIÒN DEL LIBRO(mayor de 1900 y menor a 2017): ");
            System.out.print("°°  "); 
            aniodeedicion= Leer.nextInt();
        }
        estado="L";
        oLibro = new Libro();
        oLibro.setNroRegistro(numlibro);
        oLibro.setCodigoLibro(codlibro);
        oLibro.setTitulo(titulolibro);
        oLibro.setAutor(autor);
        oLibro.setEditorial(editorial);
        oLibro.setAniodeedicion(aniodeedicion);
        oLibro.setFechaDevolucion("-");
        oLibro.setEstado(estado);
        DatosLibro.add(oLibro);
        System.out.println("\t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("\t\t Libro Registrado Satisfactoriamente...");
        System.out.println("\t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        //PREGUNTA SI DESEA CONTINUAR INGRESANDO OTRO LIBRO
        System.out.println("¿Desea Ingresar Otro Libro?(S/N):");
            System.out.print("°°  "); 
            opcion= Leer.next();       
        }
    }
     
    //PARA VALIDAR SI YA ESTÁ REGISTRADO EL CODLIBRO 
    public static int validarCodigo(String codLibro){
        int rpta=0;
        for(int i = 0;i<DatosLibro.size(); i++){
            oLibro = DatosLibro.get(i);
            if(codLibro.equals(oLibro.getCodigoLibro())){
                rpta=1;//si existe el codlibro
                break;
            }
        }  
        return rpta;
    }
    
    public static int BuscarLibroxCod(){
        System.out.println("Codigo del Libro a Buscar:");
        String cod=Leer.next();
        int pos = -1;
        oLibro = new Libro();
        for(int i = 0;i<DatosLibro.size(); i++){
            oLibro = DatosLibro.get(i);
            if(cod.equals(oLibro.getCodigoLibro())){
                pos = i;
                break;
            }
        }
        return pos;
             
    }

    //  MENU : 2. MOVIMIENTOS
     
     public static void Movimientos(){
        System.out.println("\t\t>>>> 2.Movimientos <<<<");
        System.out.println("\t********************************************");  
        String opcion="";
        while(!opcion.equals("N")){
        
        int p = BuscarLibroxCod();
        if (p==-1){
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("\t\t >>>> El libro no Existe <<<< ");
        }
        else{
             MostrasDatos(p);
             oLibro = new Libro();
             oLibro=DatosLibro.get(p);
             System.out.print("Ingrese el Estado Actual del Libro(S,D,L): ");
             String estado = Leer.next();
             oLibro.setEstado(estado);
             
             if(estado.equals("D")){
                System.out.print("Ingrese FECHA DE DEVOLUCION: ");
                String fechaD = Leer.next();
                oLibro.setFechaDevolucion(fechaD);
                DatosLibro.set(p, oLibro);
             }
            }
            System.out.println("---------------------------------------------");
            System.out.println("¿Desea Registrar Otro Movimiento?(S/N):");
            System.out.print("°°  "); 
            opcion= Leer.next(); 
        
        }//fin while
        
        }
     
    //Menu 3 : Disponibilidad
     
    public static void Disponibilidad(){
        System.out.println("\t\t>>> 3. Disponibilidad del Libro <<<");
        System.out.println("\t******************************************");
        String opcion="";
        while(!opcion.equals("N")){
        int p = BuscarLibroxCod();
        if (p ==-1){
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("\t\t>>>> El libro no Existe <<<<");
            }
        else {
            oLibro = new Libro();
            oLibro = DatosLibro.get(p);
            MostrasDatosFormato2(p,oLibro.getEstado());
             
             System.out.println("\nEl libro sera devuelto el "+oLibro.getFechaDevolucion());
            }
        
            System.out.println("-----------------------------------------------------");
            System.out.println("¿Desea Realizar otra Consulta?(S/N):");
            System.out.print("°°  "); 
            opcion= Leer.next(); 
            }//fin while
        }
    
      public static void ModificarLibro(){
        System.out.println("\t\t>>>> 4. Modificar Libro <<<<");
        System.out.println("\t****************************************************");
        String opcion="";
        while(!opcion.equals("N")){
        int p = BuscarLibroxCod();
        if (p==-1){
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("\t\t >>>> El libro no Existe <<<< ");
        }
        else{
            oLibro = new Libro();
            oLibro = DatosLibro.get(p);
            String rpta="";
            System.out.println(":: Información del Libro ");
            System.out.println("Titulo Actual del Libro:" + oLibro.getTitulo());
            System.out.println("¿DESEA ACTUALIZAR TITULO?(S/N):");
            rpta=Leer.next();
            if(rpta.equals("S")){
                System.out.println("Nuevo TÍTULO:");
                System.out.print("°° "); 
                String titulo= Leer.next(); 
                oLibro.setTitulo(titulo);
            }
            System.out.println("AUTOR Actual del Libro:" + oLibro.getAutor());
            System.out.println("¿DESEA ACTUALIZAR AUTOR?(S/N):");
            rpta=Leer.next();
            if(rpta.equals("S")){
                System.out.println("Nuevo AUTOR:");
                System.out.print("°° "); 
                String autor= Leer.next(); 
                oLibro.setAutor(autor);
            }
            System.out.println("ESTADO Actual del Libro: " + estadoEnLetras(oLibro.getEstado()));
            System.out.println("¿DESEA ACTUALIZAR ESTADO?(S/N):");
            rpta=Leer.next();
            if(rpta.equals("S")){
                System.out.println("Nuevo ESTADO(S,D,L):");
                System.out.print("°° "); 
                String estado= Leer.next(); 
                oLibro.setEstado(estado);
                if(estado.equals("D")){
                    System.out.println("FECHA DEVOLUCION:" + oLibro.getFechaDevolucion());
                    System.out.println("¿DESEA ACTUALIZAR FECHA?(S/N):");
                    rpta=Leer.next();
                    if(rpta.equals("S")){
                        System.out.println("Nueva FECHA:");
                        System.out.print("°° "); 
                        String fecha= Leer.next(); 
                        oLibro.setFechaDevolucion(fecha);
                    }
                }
            }
        }
        System.out.println("-----------------------------------------------------");
            System.out.println("¿Desea Realizar otra ACTUALIZACION?(S/N):");
            System.out.print("°°  "); 
            opcion= Leer.next(); 
            }//fin while
     }
      
      
    public static void EliminarLibro(){
        System.out.println("\t\t>>>> Eliminar Libro <<<<");
        System.out.println("\t***********************************************");
        String opcion="";
        while(!opcion.equals("N")){
        int p = BuscarLibroxCod();
        if (p==-1){
           System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
           System.out.println("\t\t >>>> El libro no Existe <<<< ");
        }
        else{
            oLibro = new Libro();
            oLibro = DatosLibro.get(p);
            MostrasDatosFormato2(p,oLibro.getEstado());
            if(oLibro.getEstado().equals("L")){
                System.out.println("\t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"); 

                System.out.println("¿Seguro Que Quiere Elimnar Este Libro(S/N)? ");
                System.out.print("°°  ");
                String Eliminacion = Leer.next();
                if (Eliminacion.equals("S")){
                    DatosLibro.remove(p);
                    System.out.println("\t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"); 
                    System.out.println("\t\t>>>Eliminacion Satisfactoria .... <<<");
                }
            
            }
            else{
                System.out.println("\t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"); 
                System.out.println("No se puede eliminar el libro porque esta PRESTADO ");
            
            }
            
            System.out.println("-----------------------------------------------------");
            System.out.println("¿Desea ELIMINAR otro Libro?(S/N):");
            System.out.print("°°  "); 
            opcion= Leer.next(); 
        }//fin while
        
        }
     }
        
        
         public static void ListarLibros(){
         System.out.println("\t\t\t\t\t\t\t** LISTADO DE LIBROS**");
         System.out.println("***************************************************************************************************************************************");
         System.out.println("NRO\tCODIGO\tTITULO\t\tAUTOR\t\tEDITORIAL\t\tAÑO DE EDICION\t\tF.DEVOLUCION\t\t ESTADO");
         System.out.println("***************************************************************************************************************************************");
        for ( int X= 0 ; X < DatosLibro.size();X++){
             oLibro= new Libro();
             oLibro = DatosLibro.get(X);
             System.out.print(oLibro.getNroRegistro());
             System.out.print("\t"+ oLibro.getCodigoLibro());;
             System.out.print("\t"+ oLibro.getTitulo());
             System.out.print("\t\t"+ oLibro.getAutor());
             System.out.print("\t\t"+ oLibro.getEditorial());
             System.out.print("\t\t\t"+ oLibro.getAniodeedicion());
             System.out.print("\t\t\t"+ oLibro.getFechaDevolucion());
             System.out.println("\t\t"+ estadoEnLetras(oLibro.getEstado()));
             System.out.println("***************************************************************************************************************************************\n");
        }  
    }
        public static void MostrasDatos(int i){ 
            oLibro= new Libro();
            oLibro = DatosLibro.get(i);
            System.out.println("NRO.\t\tTitulo\t\tAutor**");
            System.out.println("****************************************");
            System.out.print(oLibro.getNroRegistro());
            System.out.print("\t\t"+oLibro.getTitulo());
            System.out.println("\t\t"+ oLibro.getAutor());
        }
        
        public static void MostrasDatosFormato2(int i,String estado){ 
            oLibro= new Libro();
            oLibro = DatosLibro.get(i);
            System.out.print("NRO.\t\tTitulo\t\tAutor\t\tEstado");
            if(estado.equals("D"))
            {System.out.print("\t\tFecha Devolucion");
            }
            System.out.println("\n********************************************************************************");
            System.out.print(oLibro.getNroRegistro());
            System.out.print("\t\t"+oLibro.getTitulo());
            System.out.print("\t\t"+ oLibro.getAutor());
            System.out.print("\t\t"+ estadoEnLetras(oLibro.getEstado()));
            if(estado.equals("D"))
            {System.out.println("\t\t"+ oLibro.getFechaDevolucion());
            }
            
            
            
        } 
        
        public static String estadoEnLetras(String estado)
        {   String enLetras;
            
            if(estado.equals("S")){
                enLetras="SALA";
            }
            else if(estado.equals("D")){
                enLetras="Domicilio";
            }
            else{
                enLetras="Libre";
            }
            return enLetras;
        }
        
 }
   