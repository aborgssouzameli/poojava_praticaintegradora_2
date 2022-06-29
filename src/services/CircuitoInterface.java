package services;

import repositories.FaturaRepository;
import java.util.Map;

public interface CircuitoInterface {
    public void adicionarPessoaCompetidora(PessoaService pessoa);
    public Map<Integer, FaturaRepository> listarPessoasCadastradas();
}
