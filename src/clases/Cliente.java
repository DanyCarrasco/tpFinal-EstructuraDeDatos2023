package clases;

import javax.print.Doc;
import java.util.Objects;

public class Cliente implements Comparable{
    private Documento doc;
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;

    public Cliente(int numTipo, int unNumDni, String nombre, String apellido, int telefono, String email) {
        this.doc = new Documento(numTipo, unNumDni);
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Cliente(Documento doc, String nombre, String apellido, int telefono, String email) {
        this.doc = doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Cliente(Documento doc){
        this.doc = doc;
    }

    public String getTipoDocumento() {
        return this.doc.getTipo();
    }

    public int getNumeroDocumento() {
        return this.doc.getNumero();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Documento: " + this.doc.toString() + ", Nombre: " + this.nombre + ", Apellido: " + this.apellido +
                ", Telefono: " + this.telefono + ", Email: " + this.email;
    }


    public boolean equals(Object obj) {
        Cliente persona = (Cliente) obj;
        return this.doc.equals(persona.doc);
    }

    public Cliente clone() {
        return (new Cliente(this.doc.clone(), this.getNombre(), this.getApellido(), this.getTelefono(), this.getEmail()));
    }

    @Override
    public int compareTo(Object o) {
        Cliente persona = (Cliente) o;
        return this.doc.compareTo(persona.doc);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 50 * hash + Objects.hashCode(this.doc);
        return hash;
    }
}
