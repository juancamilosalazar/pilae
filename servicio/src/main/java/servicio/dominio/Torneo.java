package servicio.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Torneo implements java.io.Serializable{
    private Long codigo;
    private String nombre;
    private String descripcion;
    private Deporte fkDeporte;
}
