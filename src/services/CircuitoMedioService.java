package services;
import repositories.CircuitoMedioRepository;

public class CircuitoMedioService {
    CircuitoMedioRepository circuitoMedioRepository;
    public CircuitoMedioService() {
        circuitoMedioRepository = new CircuitoMedioRepository();
    }

    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        circuitoMedioRepository.adicionarPessoaCompetidora(pessoa);
    }
}
