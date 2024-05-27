package org.example.opprojectjava.entity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dato {

    @JsonProperty("cliente")
    private String cliente;

    @JsonAlias({"clave pedimento"})
    @JsonProperty("clave pedimento")
    private String clavePedimento;

    @JsonAlias({"tipo operacion"})
    @JsonProperty("tipo operacion")
    private String tipoOperacion;

    @JsonProperty("referencia")
    private String referencia;

    @JsonProperty("pedimento")
    private String pedimento;

    @JsonProperty("remesa")
    private String remesa;

    @JsonProperty("caja")
    private String caja;

    @JsonProperty("sello")
    private String sello;

    @JsonProperty("DODA")
    @JsonAlias({"DODA", "D0DA"})
    private String DODA;

    @JsonProperty("CP folios")
    @JsonAlias({"CP folios"})
    private String CPFolios;

    @JsonProperty("cruce/SOIA")
    @JsonAlias({"cruce/SOIA"})
    private String cruce_SOIA;

//
//    @JsonProperty("usuario...DODA")
//    @JsonAlias({"usuario...DODA"})
//    private String usuarioDODA;

    @JsonProperty("usuario")
    @JsonAlias({"usuario"})
    private String usuario;


    @JsonProperty("TIEMPO RECIBO BGTS")
    @JsonAlias({"TIEMPO RECIBO BGTS"})
    private String tiempoReciboBgts;

    @JsonProperty("TIEMPO ACG CONFIRMADO")
    @JsonAlias({"TIEMPO ACG CONFIRMADO"})
    private String tiempoAcgConfirmado;

    @JsonProperty("FECHA CCP")
    @JsonAlias({"FECHA CCP"})
    private String fechaCCP;

    @JsonProperty("Fecha de remesa")
    @JsonAlias({"Fecha de remesa"})
    private String fechaDeRemesa;



    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getClavePedimento() {
        return clavePedimento;
    }

    public void setClavePedimento(String clavePedimento) {
        this.clavePedimento = clavePedimento;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPedimento() {
        return pedimento;
    }

    public void setPedimento(String pedimento) {
        this.pedimento = pedimento;
    }

    public String getRemesa() {
        return remesa;
    }

    public void setRemesa(String remesa) {
        this.remesa = remesa;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public String getDODA() {
        return DODA;
    }

    public void setDODA(String DODA) {
        this.DODA = DODA;
    }

    public String getCPFolios() {
        return CPFolios;
    }

    public void setCPFolios(String CPFolios) {
        this.CPFolios = CPFolios;
    }

    public String getCruce_SOIA() {
        return cruce_SOIA;
    }

    public void setCruce_SOIA(String cruce_SOIA) {
        this.cruce_SOIA = cruce_SOIA;
    }
//    public String getUsuarioDODA() {
//        return usuarioDODA;
//    }
//
//    public void setUsuarioDODA(String usuarioDODA) {
//        this.usuarioDODA = usuarioDODA;
//    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTiempoReciboBgts() {
        return tiempoReciboBgts;
    }

    public void setTiempoReciboBgts(String tiempoReciboBgts) {
        this.tiempoReciboBgts = tiempoReciboBgts;
    }

    public String getTiempoAcgConfirmado() {
        return tiempoAcgConfirmado;
    }

    public void setTiempoAcgConfirmado(String tiempoAcgConfirmado) {
        this.tiempoAcgConfirmado = tiempoAcgConfirmado;
    }

    public String getFechaCCP() {
        return fechaCCP;
    }

    public void setFechaCCP(String fechaCCP) {
        this.fechaCCP = fechaCCP;
    }

    public String getFechaDeRemesa() {
        return fechaDeRemesa;
    }

    public void setFechaDeRemesa(String fechaDeRemesa) {
        this.fechaDeRemesa = fechaDeRemesa;
    }

    @Override
    public String toString() {
        return "Dato{" +
                "cliente='" + cliente + '\'' +
                ", clavePedimento='" + clavePedimento + '\'' +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", referencia='" + referencia + '\'' +
                ", pedimento='" + pedimento + '\'' +
                ", remesa='" + remesa + '\'' +
                ", caja='" + caja + '\'' +
                ", sello='" + sello + '\'' +
                ", DODA='" + DODA + '\'' +
                ", CPFolios='" + CPFolios + '\'' +
                ", cruce_SOIA='" + cruce_SOIA + '\'' +
                ", usuario='" + usuario + '\'' +
                ", tiempoReciboBgts='" + tiempoReciboBgts + '\'' +
                ", tiempoAcgConfirmado='" + tiempoAcgConfirmado + '\'' +
                ", fechaCCP='" + fechaCCP + '\'' +
                ", fechaDeRemesa='" + fechaDeRemesa + '\'' +
                '}';
    }
}
