package br.com.consultaendereco.model;

public class Endereco {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String uf;
    private String estado;

    public Endereco(DadosEndereco dadosEndereco) {
        this.cep = dadosEndereco.cep();
        this.rua = dadosEndereco.logradouro();
        this.complemento = dadosEndereco.complemento();
        this.bairro = dadosEndereco.bairro();
        this.uf = dadosEndereco.uf();
        this.estado = dadosEndereco.estado();
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return String.format("\nCep: %s\nRua: %s\nComplemento: %s\nBairro: %s\nEstado: %s\nUF: %s", cep, rua, complemento, bairro, estado, uf);
    }
}
