package services;
import repositories.CircuitoPequenoRepository;

public class CircuitoPequenoService {
    CircuitoPequenoRepository circuitoPequenoRepository;
    public CircuitoPequenoService() {
        circuitoPequenoRepository = new CircuitoPequenoRepository();
    }

    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        circuitoPequenoRepository.adicionarPessoaCompetidora(pessoa);
    }

    public void listarPessoasCadastradas() {
        circuitoPequenoRepository.listarPessoasInscritas();
    }
}
