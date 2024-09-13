package arbol_nario;
import java.util.Scanner;

public class arbol_N {
    
    private nodo raiz;
    Scanner Leer = new Scanner (System.in);
    
    public arbol_N() {
        this.raiz = null;
    }
    public nodo getRaiz() {
        return raiz;
    }
    public void mostrar(nodo r){
        nodo p=r;
        while (p!=null){
            if (!p.isSw()){
                System.out.print("||"+p.getDato()+"||  ");
            }else{
                mostrar(p.getLigaLista());
            } p=p.getLiga();
        }
    }
    public void insertarPpal(char dato){
        if (raiz==null){
            nodo x = new nodo (false, dato); raiz=x; 
        } else{
            System.out.println("\nQue dato quiere que sea el padre de ¿"+ dato +"?");
            char padre = Leer.next().charAt(0);
            boolean i=insertar(raiz, padre, dato);
            if(!i){
                System.out.println("\nEl padre deseado no existe en las listas \n"); 
            } else{
                System.out.println("\nDato ingresado con exito \n"); 
            }  
        }
    }
    public boolean insertar(nodo r, char padre, char dato){
        nodo p=r; boolean i=false;
        while(p!=null&&!i){
            if(!p.isSw()){
                if((p==raiz&&p.getDato()==padre)||(p.getDato()==padre&&p==r)){
                    while(p.getLiga()!=null){
                        p=p.getLiga();
                    }
                    nodo x = new nodo (false, dato); p.setLiga(x); i=true; return i;
                } else{
                    if(p.getDato()==padre&&p!=r){
                        nodo x = new nodo (false, p.getDato()); nodo y = new nodo (false, dato); 
                        p.setSw(true); p.setDato('.'); p.setLigaLista(x); x.setLiga(y);
                        i=true; return i;
                    }
                }p=p.getLiga();
            } else{
                i=insertar(p.getLigaLista(), padre, dato);
                if(!i){
                    p=p.getLiga();
                }
            } 
        } return i;
    }
    
    public void eliminar (nodo r, nodo k, char dato){
        nodo p=r; nodo q=k;
        while(p!=null){
            if(!p.isSw()){
                if(raiz.getDato()==dato&&p==raiz){
                    if(p.getLiga()==null){
                        p=null;
                    }else{
                        if(p.getLiga()!=null&&p.getLiga().isSw()){
                            p.setDato(p.getLiga().getLigaLista().getDato());
                            eliminar(p.getLiga().getLigaLista(),p.getLiga(),p.getLiga().getLigaLista().getDato());
                        }else{
                            if(p.getLiga()!=null&&!p.getLiga().isSw()){
                                raiz=p.getLiga(); 
                            }
                        }break;
                    }
                }else{
                    if(p.getDato()==dato&&p==r){
                        if(p.getLiga().isSw()){
                            p.setDato(p.getLiga().getLigaLista().getDato());
                            eliminar(p.getLiga().getLigaLista(), p.getLiga(), p.getLiga().getLigaLista().getDato());
                        }else{
                            if(p.getLiga().getLiga()==null){
                                q.setDato(p.getLiga().getDato()); q.setLigaLista(null); q.setSw(false);
                            }else{
                                if(p.getLiga().getLiga()!=null){
                                    q.setLigaLista(p.getLiga());
                                }
                            }
                        }
                    }else{
                        if(p.getDato()==dato&&p!=r){
                            if(q==r&&p.getLiga()==null){
                                k.setDato(p.getDato()); k.setSw(false); k.setLigaLista(null);
                            }else{
                                if(p.getLiga()==null){
                                    q.setLiga(null);
                                }else{
                                    if(p.getLiga()!=null||p.getLiga().isSw()){
                                        q.setLiga(p.getLiga());
                                    }
                                }
                            }
                        }   
                    }
                }
            }else{
                eliminar(p.getLigaLista(), q.getLiga(), dato);
            }q=p; p=p.getLiga();
        }
    }
    public nodo buscarDato(nodo r, char dato){
        nodo p=r, datoEn=null;  
        while(p!=null&&datoEn==null){
            if(!p.isSw()){
                if(p.getDato()==dato){
                    datoEn= p; return datoEn;
                }
            }else{
                datoEn=buscarDato(p.getLigaLista(), dato); 
            }p=p.getLiga();
        }return datoEn;
    }
    public void mostrarRaices(nodo r){
        nodo p=r; 
        while(p!=null){
            if(!p.isSw()){
                if(p==raiz){
                    System.out.print("||"+p.getDato()+"|| "); 
                }else{
                    if(p==r){
                        System.out.print("||"+p.getDato()+"|| "); 
                    }
                }
            }else{
                mostrarRaices(p.getLigaLista()); 
            } p=p.getLiga();
        }
    }
    public int contarHojas(nodo r){
        nodo p=r; int i=0;
        while(p!=null){
            if(!p.isSw()){
                if(p!=raiz&&p!=r){
                    i++;
                }
            }else{
                i=i+contarHojas(p.getLigaLista()); 
            }
            p=p.getLiga();
        }return i;
    }
    public void mostrarHojas(nodo r){
       nodo p=r;  
        while(p!=null){
            if(!p.isSw()){
                if(p!=raiz&&p!=r){
                    System.out.print("||"+p.getDato()+"|| ");
                }
            }else{
                mostrarHojas(p.getLigaLista()); 
            }
            p=p.getLiga();
        } 
    }
    public int mostrarGrado(nodo r){
        nodo p=r; int grado=0, maygdo=0, gdo;
        while(p!=null){
            if(!p.isSw()){
                if(p!=raiz&&p!=r){
                    grado++;
                }
            } else{
                grado++; gdo=mostrarGrado(p.getLigaLista());
                if(gdo>=maygdo){
                    maygdo=gdo;
                }  
            } p=p.getLiga();
        }
        if(maygdo>=grado){
            grado=maygdo;
        }       
       return grado;         
    }
    public void mostrarGradoDatoE(nodo r, char dato){
        nodo p=r;
        while(p!=null){
            if(!p.isSw()){
                if((p.getDato()==dato&&p==r)||(p.getDato()==dato&&p==raiz)){
                    System.out.println("\nEl grado del dato dato es: "+mostrarGrado(p)+" \n");
                }else{
                    if(p.getDato()==dato){
                        System.out.println("\nEl grado del dato es: "+0+"\n");
                    }
                }
            }else{
                mostrarGradoDatoE(p.getLigaLista(), dato); 
            }p=p.getLiga();
        }
    }
    public void mostrarHijosDatoE(nodo r, char dato){
        nodo p=r;
        while(p!=null){
            if(!p.isSw()){
                if(p.getDato()==dato&&p==r){
                    System.out.println("\nLos hijos del dato: "+p.getDato()+" son:  "); mostrar(p.getLiga()); System.out.println("\n");
                }else{
                    if(p.getDato()==dato&&p==raiz){
                        System.out.println("\nLos hijos del dato: "+p.getDato()+" son:  "); mostrar(p.getLiga()); System.out.println("\n");
                    }else{
                        if(p.getDato()==dato){
                            System.out.println("\nEl dato "+p.getDato()+" no tiene hijos\n"); break; 
                        }
                    }
                }
            }else{
                mostrarHijosDatoE(p.getLigaLista(), dato); 
            }p=p.getLiga();
        }
    }
    public void mostrarHermanosDatoE(nodo r, int lvldato, int lvlact, char dato){
        nodo p=r; int nv=lvlact;
        while(p!=null){
            if(!p.isSw()){
                if(nv==lvldato&&p.getDato()!=dato){
                    System.out.print("||"+p.getDato()+"|| ");
                }
            }else{
                mostrarHermanosDatoE(p.getLigaLista(), lvldato, nv, dato); 
            }
            if(p==r||p==raiz){
                nv++;
            }p=p.getLiga();
        }
    }
    public int mostrarNivelDatoE(nodo r, char dato, int lvl){
        nodo p=r; int nv=lvl, i; 
        while(p!=null){
            if(!p.isSw()){
                if(p.getDato()==dato&&p==raiz){
                    return nv;
                }else{
                    if(p.getDato()==dato){
                        return nv;
                    }
                }
            }else{
                i=mostrarNivelDatoE(p.getLigaLista(), dato, nv); 
                if(i!=0){
                    nv=i; return nv;
                }
            }
            if((p==r||p==raiz)&&p.getDato()!=dato){
                nv++;
            }p=p.getLiga();
        }return 0;
    }
    public int mostrarAltura(nodo r, int att){
        nodo p=r; int altura=att, mayalt=1, alt;
        while(p!=null){
            if(!p.isSw()){
                if((p==raiz||p==r)&&p.getLiga()!=null){
                    altura++;
                }
            }else{
                alt=mostrarAltura(p.getLigaLista(), altura); 
                if(alt>=mayalt){
                    mayalt=alt; 
                }
            }p=p.getLiga();
        }
        if(mayalt>=altura){
            return mayalt;
        } return altura;
    }
    public void mostrarPadreDato(nodo r, char dato, char padreact){
        nodo p=r; char padre=padreact;
        while(p!=null){
            if(!p.isSw()){
                if(p==raiz&&p.getDato()==dato){
                    System.out.println("\nEl dato no tiene padres \n");
                }else{
                    if(p==r&&p.getDato()!=dato){
                        padre=p.getDato();
                    }else{
                        if(p.getDato()==dato){
                            System.out.println("\nEl padre de "+dato+" es "+padre+"\n"); break;
                        }
                    }
                }
            }else{
                mostrarPadreDato(p.getLigaLista(), dato, padre);
            }p=p.getLiga();
        }
    }
    public void mostrarDatosNivel(nodo r, int nv, int nvact){
        nodo p=r; int nivel=nvact;
        while(p!=null){
            if(!p.isSw()){
                if(nivel==nv){
                    System.out.print("||"+p.getDato()+"|| ");
                }
            }else{
                mostrarDatosNivel(p.getLigaLista(), nv, nivel); 
            }
            if(p==r||p==raiz){
                nivel++;
            }p=p.getLiga();
        }
    }
    public void eliminarNodosNivel(nodo r, int nv, int nvact){
        nodo p=r; int nivel=nvact;
        while(p!=null){
            if(!p.isSw()){
                if(nivel==nv){
                    eliminar(raiz, raiz, p.getDato());
                }
            }else{
                eliminarNodosNivel(p.getLigaLista(), nv, nivel); 
            }
            if(p==r||p==raiz){
                nivel++;
            }p=p.getLiga();
        }
    }
}
