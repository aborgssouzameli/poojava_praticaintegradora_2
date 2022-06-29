package services;

import repositories.PessoaRepository;

public class PessoaService {
    PessoaRepository pessoa;
    public void adicionarPessoa(int registroGeral, String nomePessoa, String sobrenomePessoa, int idadePessoa, int numeroCelularPessoa, int numeroEmergencia, String grupoSanguineo) {
        pessoa = new PessoaRepository(registroGeral, nomePessoa, sobrenomePessoa, idadePessoa, numeroCelularPessoa, numeroEmergencia, grupoSanguineo);
    }

    public PessoaRepository retornarInstanciaPessoa() {
        return pessoa;
    }
    public int getRegistroGeral() { return pessoa.getRegistroGeral();}
    public String getNome() { return pessoa.getNomePessoa();}
    public String getSobrenome() { return pessoa.getSobrenomePessoa();}
    public int getIdade() {
        return pessoa.getIdadePessoa();
    }
    public int getNumeroCelular() { return pessoa.getNumeroCelularPessoa();}
    public int getNumeroEmergencial() { return pessoa.getNumeroEmergencia();}
    public String getGrupoSanguineo() { return pessoa.getGrupoSanguineo(); }
}
