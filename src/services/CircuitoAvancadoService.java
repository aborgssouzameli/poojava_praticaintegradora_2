package services;

import repositories.CircuitoAvancadoRepository;
import repositories.CircuitoPequenoRepository;

public class CircuitoAvancadoService {
    CircuitoAvancadoRepository circuitoAvancadoRepository;
    public CircuitoAvancadoService() {
        circuitoAvancadoRepository = new CircuitoAvancadoRepository();
    }

    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        circuitoAvancadoRepository.adicionarPessoaCompetidora(pessoa);
    }

    public void listarPessoasCadastradas() {

    }
}
