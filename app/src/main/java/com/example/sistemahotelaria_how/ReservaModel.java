package com.example.sistemahotelaria_how;

public class ReservaModel {

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private String NomeHospede;
    private String NomeColaborador;
    private String DatReserva;

    public String getNomeHospede() {
        return NomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        NomeHospede = nomeHospede;
    }

    public String getNomeColaborador() {
        return NomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        NomeColaborador = nomeColaborador;
    }

    public String getDatReserva() {
        return DatReserva;
    }

    public void setDatReserva(String datReserva) {
        DatReserva = datReserva;
    }


}
