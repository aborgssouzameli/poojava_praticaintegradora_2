package repositories;

import services.PessoaService;

import java.util.HashMap;
import java.util.Map;

public interface CircuitoRepositoryInterface {

    public void adicionarPessoaCompetidora(PessoaService pessoa);
    public void excluirPessoaCompetidora(int codigoPessoaCompetidora);
    public HashMap<Integer, FaturaRepository> listarPessoasInscritas();

}
