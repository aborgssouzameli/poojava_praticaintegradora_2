import repositories.FaturaRepository;
import repositories.PessoaRepository;
import services.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AppCorrida {
    private CircuitoInterface circuitoPequenoService = new CircuitoPequenoService();
    private CircuitoInterface circuitoMedioService = new CircuitoMedioService();
    private CircuitoInterface circuitoAvancadoService = new CircuitoAvancadoService();

    public static void main(String args[]){
        AppCorrida appCorrida = new AppCorrida();
        appCorrida.inicializaApp();
    }

    private void inicializaApp() {
        final String PREFIXO_CADASTRO = "Cadastrar nova pessoa competidora";
        try {
            Scanner in = new Scanner(System.in);
            int opcaoMenu;
            do {
                System.out.println("\nEntre com a opção abaixo:");
                System.out.printf("\n%d\t-\t%s - %s", 1, PREFIXO_CADASTRO, "Circuito Pequeno" );
                System.out.printf("\n%d\t-\t%s - %s", 2, PREFIXO_CADASTRO, "Circuito Médio" );
                System.out.printf("\n%d\t-\t%s - %s", 3, PREFIXO_CADASTRO, "Circuito Avançado" );
                System.out.printf("\n%d\t-\t%s - %s", 4, PREFIXO_CADASTRO, "Listar todos inscritos" );
                System.out.printf("\n%d\t-\t%s - %s", 5, PREFIXO_CADASTRO, "Listar todos inscritos na categoria Circuito Pequeno" );
                System.out.printf("\n%d\t-\t%s - %s", 6, PREFIXO_CADASTRO, "Listar todos inscritos na categoria Circuito Médio" );
                System.out.printf("\n%d\t-\t%s - %s", 7, PREFIXO_CADASTRO, "Listar todos inscritos na categoria Circuito Avançada" );
                System.out.printf("\n%d\t-\t%s", 9, "Sair" );
                System.out.println("\nSelecione a opção: ");
                String input = in.nextLine();
                opcaoMenu = Integer.parseInt(input);

                if ((opcaoMenu >= 1) && (opcaoMenu <= 7)) {
                    switch (opcaoMenu) {
                        case 1: {
                            circuitoPequenoService.adicionarPessoaCompetidora(this.registrarDadosPessoaCompetidora());
                            break;
                        }
                        case 2: {
                            circuitoMedioService.adicionarPessoaCompetidora(this.registrarDadosPessoaCompetidora());
                            break;
                        }
                        case 3: {
                            if (registrarDadosPessoaCompetidora().getIdade() > 18) {
                                circuitoAvancadoService.adicionarPessoaCompetidora(this.registrarDadosPessoaCompetidora());
                            }
                            else {
                                System.out.println("Cadastro não permitido. Idade inferior à modalidade informada.");
                            }
                            break;
                        }
                        case 4: {
                            HashMap<Integer, CircuitoInterface> circuitos = new HashMap<>();
                            circuitos.put(1, circuitoPequenoService);
                            circuitos.put(2, circuitoMedioService);
                            circuitos.put(3, circuitoAvancadoService);
                            break;
                        }
                        case 5: {
                            listarIncritos(circuitoPequenoService);
                            break;
                        }
                        case 6: {
                            listarIncritos(circuitoMedioService);
                            break;
                        }
                        case 7: {
                            listarIncritos(circuitoAvancadoService);
                            break;
                        }
                    }
                }
            }
            while (opcaoMenu != 9);
        }
        catch (NumberFormatException e) {
            System.out.println("Entrada com menu inválida");
        }
    }

    private PessoaService registrarDadosPessoaCompetidora() {
        PessoaService pessoaCompetidora = new PessoaService();
        try {
            Scanner entradaTeclado = new Scanner(System.in);
            System.out.println("\nInforme o nome:");
            String nomePessoa = entradaTeclado.nextLine();
            System.out.println("\nInforme o sobrenome:");
            String sobrenomePessoa = entradaTeclado.nextLine();
            System.out.println("\nInforme a idade:");
            int idadePessoa = Integer.parseInt(entradaTeclado.nextLine());
            System.out.println("\nInforme apenas número RG:");
            int numeroRegistroGeral = Integer.parseInt(entradaTeclado.nextLine());
            System.out.println("\nInforme apenas o número celular");
            int numeroCelular = Integer.parseInt(entradaTeclado.nextLine());
            System.out.println("\nInforme apenas o número da emergencência");
            int numeroEmergencia = Integer.parseInt(entradaTeclado.nextLine());
            System.out.println("\nInforme apenas o grupo sanguíneo:");
            String grupoSanguineo = entradaTeclado.nextLine();
            pessoaCompetidora.adicionarPessoa(numeroRegistroGeral, nomePessoa, sobrenomePessoa, idadePessoa, numeroCelular, numeroEmergencia, grupoSanguineo);
        }
        catch (NumberFormatException e) {
            System.out.println("Entrada com menu inválida");
        }
        return pessoaCompetidora;
    }

    private void listarInscritos(HashMap<Integer, CircuitoInterface> ciruitos) {
        for (Map.Entry<Integer, CircuitoInterface> circuito: ciruitos.entrySet()) {
            listarIncritos(circuito.getValue());
        }
    }

    private void listarIncritos(CircuitoInterface circuito) {
        Map<Integer, FaturaRepository> circuitoInterface = circuito.listarPessoasCadastradas();
        for (Map.Entry<Integer, FaturaRepository> c: circuitoInterface.entrySet()) {
            FaturaRepository fatura = c.getValue();
            double valorFaturado = fatura.getValorFatura();
            PessoaRepository pessoa = fatura.getPessoa();
            System.out.printf(
                    "\nNúmero: %d - RG: %d | Nome completo %s %s | Idade: %d | Grupo Sanguíneo: %s | Telefone celular: %d | Telefone emergencial: %d | Valor faturado: %.2f",
                    c.getKey(),
                    pessoa.getRegistroGeral(),
                    pessoa.getNomePessoa(),
                    pessoa.getSobrenomePessoa(),
                    pessoa.getIdadePessoa(),
                    pessoa.getGrupoSanguineo(),
                    pessoa.getNumeroCelularPessoa(),
                    pessoa.getNumeroEmergencia(),
                    valorFaturado
            );
        }
    }
}
