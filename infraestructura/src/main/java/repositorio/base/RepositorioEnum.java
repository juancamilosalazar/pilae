package repositorio.base;

public enum RepositorioEnum {
    TORNEO("torneo"),
    EQUIPO("equipo"),
    DEPORTE("deporte");

    public final String label;

    private RepositorioEnum(String label) {
        this.label = label;
    }
}
