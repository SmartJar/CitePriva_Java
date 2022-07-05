package es.license.citapriva.model;
import java.io.Serializable;

public class SedeInfo implements Serializable {

    private int id;
    private String Pais;
    private CityModel Officina;
    private String FechaCita;
    private String HoreCita;
    private String NIE;
    private String Nombre;
    private String PrimerApellido;
    private String ProvinciaResidencia;
    private int ProvinciaResidenciaId;
    private String FechaNacimiento;
    private String NCarta;
    private String NPermiso;
    private String FechaExpedicion;
    private String LugarExpedicion;
    private String Email;
    private String Status;

    public String getPais() {
        return Pais;
    }

    public String getProvinciaResidencia() {
        return ProvinciaResidencia;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public CityModel getOfficina() {
        return Officina;
    }

    public String getNPermiso() {
        return NPermiso;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getNIE() {
        return NIE;
    }

    public String getNCarta() {
        return NCarta;
    }

    public String getLugarExpedicion() {
        return LugarExpedicion;
    }

    public String getHoreCita() {
        return HoreCita;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public String getFechaExpedicion() {
        return FechaExpedicion;
    }

    public String getFechaCita() {
        return FechaCita;
    }

    public String getEmail() {
        return Email;
    }

    public int getId() {
        return id;
    }


    public String getStatus() {
        return Status;
    }

    public int getProvinciaResidenciaId() {
        return ProvinciaResidenciaId;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public void setProvinciaResidenciaId(int provinciaResidenciaId) {
        ProvinciaResidenciaId = provinciaResidenciaId;
    }

    public void setProvinciaResidencia(String provinciaResidencia) {
        ProvinciaResidencia = provinciaResidencia;
    }

    public void setPrimerApellido(String primerApellido) {
        PrimerApellido = primerApellido;
    }

    public void setOficina(CityModel oficina) {
        Officina = oficina;
    }

    public void setNPermiso(String NPermiso) {
        this.NPermiso = NPermiso;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setNIE(String NIE) {
        this.NIE = NIE;
    }

    public void setNCarta(String NCarta) {
        this.NCarta = NCarta;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        LugarExpedicion = lugarExpedicion;
    }

    public void setHoreCita(String horeCita) {
        HoreCita = horeCita;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        FechaExpedicion = fechaExpedicion;
    }

    public void setFechaCita(String fechaCita) {
        FechaCita = fechaCita;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "SedeInfo{" +
                "id=" + id +
                ", Pais='" + Pais + '\'' +
                ", Officina=" + Officina +
                ", FechaCita='" + FechaCita + '\'' +
                ", HoreCita='" + HoreCita + '\'' +
                ", NIE='" + NIE + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", PrimerApellido='" + PrimerApellido + '\'' +
                ", ProvinciaResidencia='" + ProvinciaResidencia + '\'' +
                ", ProvinciaResidenciaId=" + ProvinciaResidenciaId +
                ", FechaNacimiento='" + FechaNacimiento + '\'' +
                ", NCarta='" + NCarta + '\'' +
                ", NPermiso='" + NPermiso + '\'' +
                ", FechaExpedicion='" + FechaExpedicion + '\'' +
                ", LugarExpedicion='" + LugarExpedicion + '\'' +
                ", Email='" + Email + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
