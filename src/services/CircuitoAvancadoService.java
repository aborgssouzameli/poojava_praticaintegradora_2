package services;

import repositories.CircuitoAvancadoRepository;
import repositories.FaturaRepository;

import java.util.Map;

public class CircuitoAvancadoService implements CircuitoInterface {
    CircuitoAvancadoRepository circuitoAvancadoRepository;
    public CircuitoAvancadoService() {
        circuitoAvancadoRepository = new CircuitoAvancadoRepository();
    }

    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        circuitoAvancadoRepository.adicionarPessoaCompetidora(pessoa);
    }

    public Map<Integer, FaturaRepository> listarPessoasCadastradas() {
        return circuitoAvancadoRepository.listarPessoasInscritas();
    }
}
