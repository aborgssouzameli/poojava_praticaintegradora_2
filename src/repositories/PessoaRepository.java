package repositories;

public class PessoaRepository {
    private int registroGeral;
    private String nomePessoa;
    private String sobrenomePessoa;
    private int idadePessoa;
    private int numeroCelularPessoa;
    private int numeroEmergencia;
    private String grupoSanguineo;

    public PessoaRepository(int registroGeral, String nomePessoa, String sobrenomePessoa, int idadePessoa, int numeroCelularPessoa, int numeroEmergencia, String grupoSanguineo) {
        this.registroGeral = registroGeral;
        this.nomePessoa = nomePessoa;
        this.sobrenomePessoa = sobrenomePessoa;
        this.idadePessoa = idadePessoa;
        this.numeroCelularPessoa = numeroCelularPessoa;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getRegistroGeral() {
        return registroGeral;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getSobrenomePessoa() {
        return sobrenomePessoa;
    }

    public int getIdadePessoa() {
        return idadePessoa;
    }

    public int getNumeroCelularPessoa() {
        return numeroCelularPessoa;
    }

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}
