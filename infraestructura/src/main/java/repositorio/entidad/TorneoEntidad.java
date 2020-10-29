package repositorio.entidad;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "torneo")
public class TorneoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_torneo", nullable = false)
    private Long codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    @JoinColumn(name = "id_deporte", nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private DeporteEntidad fkDeporte;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DeporteEntidad getFkDeporte() {
        return fkDeporte;
    }

    public void setFkDeporte(DeporteEntidad fkDeporte) {
        this.fkDeporte = fkDeporte;
    }
}
