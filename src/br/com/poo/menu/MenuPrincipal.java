package br.com.poo.menu;

import java.io.IOException;

import br.com.poo.contas.Conta;
import br.com.poo.pessoas.Funcionario;
import br.com.poo.pessoas.Pessoa;

public class MenuPrincipal {

    public void menuPrincipal(Pessoa pessoa, Conta conta, Funcionario funcionario) throws IOException {

        MenuOpcao menuOp = new MenuOpcao();

        try {
            if (funcionario == null) {
                menuOp.menuCliente(pessoa, conta);
            } else {
                menuOp.menuFuncionarioOp(pessoa, conta, funcionario);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
