package arbol_nario;

import java.util.Scanner;

public class ArbolN_ario {

    public static void main(String[] args) {
       Scanner Leer = new Scanner (System.in);
       
       int opmenu=2; arbol_N arbol = new arbol_N();
        arbol.insertarPpal('x');
        arbol.insertar(arbol.getRaiz(), 'x', 'c');
        arbol.insertar(arbol.getRaiz(), 'x', 'f');
        arbol.insertar(arbol.getRaiz(), 'x', 'h');
        arbol.insertar(arbol.getRaiz(), 'x', 's');
        arbol.insertar(arbol.getRaiz(), 'c', 'd');
        arbol.insertar(arbol.getRaiz(), 'c', 'e');
        arbol.insertar(arbol.getRaiz(), 'h', 'w');
        arbol.insertar(arbol.getRaiz(), 'h', 'g');
        arbol.insertar(arbol.getRaiz(), 'h', 'k');
        arbol.insertar(arbol.getRaiz(), 'h', 'm');
        arbol.insertar(arbol.getRaiz(), 'w', 'a');
        arbol.insertar(arbol.getRaiz(), 'w', 'b');
        arbol.insertar(arbol.getRaiz(), 'g', 'z');
        /*arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'z');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'x');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 's');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'h');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'f');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'w');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'c');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'e');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'm');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'b');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'a');
        arbol.eliminar (arbol.getRaiz(), arbol.getRaiz(), 'g');
        arbol.mostrar(arbol.getRaiz());*/
        
       while (opmenu!=17){
           menu();
           opmenu = Leer.nextInt(); Leer.nextLine();
           eleccion(opmenu, arbol);
       }
        
    }
    
    public static void menu(){
        System.out.println("""
                        ------------------MENU------------------
                        1. Mostrar el Arbol n-ario
                        2. Insertar un dato
                        3. Eliminar un dato
                        4. Buscar un dato
                        5. Mostrar las raices del arbol
                        6. Contar el numero de hojas del arbol
                        7. Mostrar las hojas del arbol
                        8. Mostrar el grado del arbol
                        9. Mostrar el Grado de un dato especifico
                        10. Mostrar los hijos de un dato
                        11. Mostrar los hermanos de un dato
                        12. Mostrar el nivel de un dato
                        13. Mostrar la altura del arbol
                        14. Mostrar el padre de un dato
                        15. Mostrar los datos de un nivel especifico
                        16. Eliminar todos los nodos de un nivel especifico
                        17. Salir

                        Elija una opcion:""");
    }
    public static void eleccion (int opmenu, arbol_N arbol){
        Scanner Leer = new Scanner (System.in); char dato; nodo x;
        switch (opmenu){
            case 1: 
                System.out.println("");
                arbol.mostrar(arbol.getRaiz()); System.out.println("\n");
                break;
            case 2: 
                System.out.println("\nEscriba el dato a ingresar en el arbol");
                dato = Leer.next().charAt(0);
                arbol.insertarPpal(dato);
                break;
            case 3:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nEscriba el dato a eliminar del arbol");
                    dato = Leer.next().charAt(0);
                    x= arbol.buscarDato(arbol.getRaiz(), dato);
                    if(x==null){
                        System.out.println("\nEl dato ingresado no existe en el arbol \n");
                    }else{
                        arbol.eliminar(arbol.getRaiz(), arbol.getRaiz(), dato);
                    }
                }
                break;
            case 4:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nIngrese el dato a encontrar");
                    dato = Leer.next().charAt(0);
                    nodo p= arbol.buscarDato(arbol.getRaiz(), dato);
                    if(p==null){
                        System.out.println("\nNo existe ese dato en el arbol\n"); break;
                    }else{
                        System.out.println("\nDato encontrado ---->> ||"+arbol.buscarDato(arbol.getRaiz(), dato).getDato()+"||\n");
                    }
                }break;
            case 5:
                if(arbolSinDatos(arbol)){
                    System.out.println(""); arbol.mostrarRaices(arbol.getRaiz()); System.out.println("\n");
                }break;
            case 6:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nEl arbol tiene: "+arbol.contarHojas(arbol.getRaiz())+" hojas\n"); 
                }break;
            case 7:
                if(arbolSinDatos(arbol)){
                    System.out.println(""); arbol.mostrarHojas(arbol.getRaiz()); System.out.println("\n");
                }break;
            case 8:
                System.out.println("\nEl grado del arbol es: "+arbol.mostrarGrado(arbol.getRaiz())+"\n");
                break;
            case 9:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nIngrese el dato a encontrarle su grado");
                    dato = Leer.next().charAt(0);
                    arbol.mostrarGradoDatoE(arbol.getRaiz(),dato);
                }break;
            case 10:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nIngrese el dato a encontrarle sus hijos");
                    dato = Leer.next().charAt(0);
                    arbol.mostrarHijosDatoE(arbol.getRaiz(),dato);
                }break;
            case 11:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nIngrese el dato a encontrarle sus hermanos");
                    dato = Leer.next().charAt(0);
                    
                    x= arbol.buscarDato(arbol.getRaiz(), dato);
                    if(x==null){
                        System.out.println("\nEl dato ingresado no existe en el arbol \n");
                    }else{
                        if(x==arbol.getRaiz()){
                            System.out.println("\nEl dato no tiene hermanos porque es la raiz \n");
                        }else{
                            nodo padre=arbol.mostrarPadreDato(arbol.getRaiz(), dato, arbol.getRaiz());
                            int nivel= arbol.mostrarNivelDatoE(arbol.getRaiz(), dato, 0);
                            System.out.println("\nLos hermanos del dato "+dato+" son: \n");
                            arbol.mostrarHermanosDatoE(padre, nivel, arbol.mostrarNivelDatoE(arbol.getRaiz(), padre.getDato(), 0), dato); System.out.println("\n");
                        }
                    }
                }break;
            case 12:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nIngrese el dato a encontrarle su nivel");
                    dato = Leer.next().charAt(0);
                    x= arbol.buscarDato(arbol.getRaiz(), dato);
                    if(x==null){
                        System.out.println("\nEl dato ingresado no existe en el arbol \n");
                    }else{
                        System.out.println("\nEl nivel del dato ingresado es: "+arbol.mostrarNivelDatoE(arbol.getRaiz(), dato, 0)+"\n");
                    }
                }break;
            case 13:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nLa altura del arbol es: "+arbol.mostrarAltura(arbol.getRaiz(), 1)+" \n");
                }break;
            case 14:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nIngrese el dato a encontrarle su padre");
                    dato = Leer.next().charAt(0);
                    x= arbol.buscarDato(arbol.getRaiz(), dato);
                    if(x==null){
                        System.out.println("\nEl dato ingresado no existe en el arbol \n");
                    }else{
                        if(arbol.mostrarPadreDato(arbol.getRaiz(), dato, arbol.getRaiz())==null){
                            System.out.println("\nEl dato ingresado no tiene ningun padre \n");
                        }else{
                            System.out.println("\nEl padre del dato "+dato+ " es "+arbol.mostrarPadreDato(arbol.getRaiz(), dato, arbol.getRaiz()).getDato()+"\n");
                        }
                    }
                }break;
            case 15:
                if(arbolSinDatos(arbol)){
                    System.out.println("\nIngrese el nivel para buscar los datos \n");
                    int nivel= Leer.nextInt(); Leer.nextLine();
                    if(arbol.mostrarAltura(arbol.getRaiz(), 0)<nivel){
                        System.out.println("\nEl nivel ingresado no es valido porque es mayor al del arbol \n");
                    }else{
                        System.out.println("\nLos datos de nivel "+nivel+" son: \n "); arbol.mostrarDatosNivel(arbol.getRaiz(), nivel, 0); System.out.println("\n");
                    }
                }break;
            case 16:
                if(arbolSinDatos(arbol)){
                   System.out.println("\nIngrese el nivel para eliminar los nodos");
                    int nivel= Leer.nextInt(); Leer.nextLine();
                    if(arbol.mostrarAltura(arbol.getRaiz(), 0)<nivel){
                        System.out.println("\nEl nivel ingresado no es valido porque es mayor al del arbol \n");
                    }else{
                        arbol.eliminarNodosNivel(arbol.getRaiz(), nivel, 0); System.out.println("");
                        System.out.println("Nodos eliminados \n");
                    } 
                }break;
            case 17:
                System.out.println("\nProcesos terminados \n");
                break;
            default:
                System.out.println("\nElija una opcion valida \n"); 
                break;
        }
    }
    public static boolean arbolSinDatos(arbol_N a){
        if(a.getRaiz()==null){
            System.out.println("\nNo se puede realizar el proceso porque el arbol no tiene ningun dato \n");
        } return true;
    }
    
}
