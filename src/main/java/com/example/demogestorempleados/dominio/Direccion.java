package com.example.demogestorempleados.dominio;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "codigoPostal")
    private String codigoPostal;

    // Constructores, getters y setters

    public Direccion() {
    }

    public Direccion(Cliente cliente, String direccion, String ciudad, String codigoPostal) {
        this.cliente = cliente;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    // equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion1 = (Direccion) o;
        return id == direccion1.id &&
                Objects.equals(cliente, direccion1.cliente) &&
                Objects.equals(direccion, direccion1.direccion) &&
                Objects.equals(ciudad, direccion1.ciudad) &&
                Objects.equals(codigoPostal, direccion1.codigoPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, direccion, ciudad, codigoPostal);
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}