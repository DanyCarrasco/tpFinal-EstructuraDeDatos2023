package clases;

import javax.print.Doc;
import java.util.Objects;

public class Documento implements Comparable{
    private String tipo;
    private int numero;

    private void asignarTipo(int num) {
        TipoDocumento tiposDoc = new TipoDocumento();
        tipo = tiposDoc.getTipoDocumento(num);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + this.numero;
        return hash;
    }

    public Documento(int numTipo, int numero){
        asignarTipo(numTipo);
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean equals(Object obj){
        Documento doc = (Documento) obj;
        return this.tipo.equals(doc.getTipo()) && (this.numero == doc.getNumero());
    }

    public String toString(){
        return "tipo: "+ this.tipo + ", numero: "+ this.numero;
    }

    @Override
    public int compareTo(Object obj) {
        int salida;
        Documento doc = (Documento) obj;
        if (this.tipo.compareTo(doc.getTipo()) < 0){
            salida = -1;
        } else {
            if (this.tipo.compareTo(doc.getTipo()) > 0) {
                salida = 1;
            } else {
                if (this.numero < doc.getNumero()) {
                    salida = -2;
                } else {
                    if (this.numero > doc.getNumero()) {
                        salida = 2;
                    } else {
                        salida = 0;
                    }
                }
            }
        }
        return salida;
    }

    public Documento clone(){
        TipoDocumento doc = new TipoDocumento();
        return (new Documento(doc.localizarTipoDocumento(this.tipo), this.getNumero()));
    }
}
