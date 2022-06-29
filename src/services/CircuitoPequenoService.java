package services;
import repositories.CircuitoPequenoRepository;
import repositories.FaturaRepository;

import java.util.Map;

public class CircuitoPequenoService implements CircuitoInterface {
    CircuitoPequenoRepository circuitoPequenoRepository;
    public CircuitoPequenoService() {
        circuitoPequenoRepository = new CircuitoPequenoRepository();
    }

    @Override
    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        circuitoPequenoRepository.adicionarPessoaCompetidora(pessoa);
    }

    @Override
    public Map<Integer, FaturaRepository> listarPessoasCadastradas() {
        return circuitoPequenoRepository.listarPessoasInscritas();
    }
}
