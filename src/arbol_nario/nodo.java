package arbol_nario;

public class nodo {
    
    private boolean sw; private nodo ligaLista; private char dato; private nodo liga;

    public nodo(boolean sw, char dato) {
        this.sw = false ;
        this.dato = dato;
    }
    public boolean isSw() {
        return sw;
    }
    public void setSw(boolean sw) {
        this.sw = sw;
    }
    public nodo getLigaLista() {
        return ligaLista;
    }
    public void setLigaLista(nodo ligaLista) {
        this.ligaLista = ligaLista;
    }
    public char getDato() {
        return dato;
    }
    public void setDato(char dato) {
        this.dato = dato;
    }
    public nodo getLiga() {
        return liga;
    }
    public void setLiga(nodo liga) {
        this.liga = liga;
    }
}
