package br.devdeloop.arthur.controllers;

import br.devdeloop.arthur.database.MyDataBaseSingleton;
import br.devdeloop.arthur.services.RegisterService;
import br.devdeloop.arthur.services.ReportService;

public class SystemController {
    // Criação da instância aqui, para conseguir usar no construtor do meu SystemController, quero que os 2 serviços
    // consiga usar a mesma instância do "Banco de Dados". Assim, manipulando a mesma estrutura, mesmo em classes
    // diferentes. Foi a solução que pensei para suprir a necessidade de armazenamento de informações

    // Att 1: Descobri o que é singleton e apliquei aqui, fazia sentido, mas o metodo de reaproveitar a instância
    // funciona também.

    private MyDataBaseSingleton myDataBaseSingleton = MyDataBaseSingleton.getInstance();

    private RegisterService registerService;
    private ReportService reportService;

    public SystemController() {
        this.registerService = new RegisterService(this.myDataBaseSingleton);
        this.reportService = new ReportService(this.myDataBaseSingleton);
    }

    /*
        Implementação da lógica usando os métodos prontos na camada de Service.
    */
}
