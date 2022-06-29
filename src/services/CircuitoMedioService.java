package services;
import repositories.CircuitoMedioRepository;
import repositories.FaturaRepository;

import java.util.Map;

public class CircuitoMedioService implements CircuitoInterface {
    CircuitoMedioRepository circuitoMedioRepository;
    public CircuitoMedioService() {
        circuitoMedioRepository = new CircuitoMedioRepository();
    }

    @Override
    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        circuitoMedioRepository.adicionarPessoaCompetidora(pessoa);
    }

    @Override
    public Map<Integer, FaturaRepository> listarPessoasCadastradas() {
        return circuitoMedioRepository.listarPessoasInscritas();
    }
}
