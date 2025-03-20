import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    //banco de dados
    private BilheteUnico[] bilhete = new BilheteUnico[2];
    private int index =0;



    //menu principal vai fazer a classe funfar
    public void menuPrincipal(){
        int opcao = 0;
        String menu = "1. Administrador\n 2. Usuário\n 3. Finalizar";

        do{

            opcao = parseInt(showInputDialog(menu));
            switch (opcao){
                case 1:
                    menuAdmistrador();
                    break;
            }
        }while(opcao != 3);
    }
    private void menuAdmistrador(){
        int opcao = 0;
        String menu = "MENU ADMINISTRADOR\n";
        menu += "1. Emitir Bilhete\n ";
        menu +="2. Listar Bilhete\n";
        menu+= "3. Excluir Bilhete\n";
        menu+= "4. Sair";

        do{

            opcao = parseInt(showInputDialog(menu));
            switch (opcao){
                case 1:
                    emitirBilhete();
                    break;
                case 2:
                    listarBilhete();
                    break;
            }

        }while(opcao != 4);
    }
    private void emitirBilhete(){

        String nome, perfil;
        long cpf;
        if (index <bilhete.length){

            nome = showInputDialog("Nome do usuário:");
            cpf = parseLong(showInputDialog("CPF:"));
            perfil = showInputDialog("Perfil do usuário(Estudante, Professor ou Comum):");
            bilhete[index]= new BilheteUnico(nome, cpf, perfil);
            index++;

        }else{
            showMessageDialog(null,"O bilhete não foi emitido, procure um posto de atendimento.");
        }

    }
    private void listarBilhete(){

        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";

        for(int i=0;i<index;i++){
            aux += "Número do Bilhete:" + bilhete[i].numero+"\n";
            aux += "Saldo do Bilhete: R$ " +df.format( bilhete[i].saldo)+"\n";
            aux += "Usuário:" + bilhete[i].usuario.nome+"\n";
            aux += "Perfil:" + bilhete[i].usuario.perfil+"\n";
            aux += "CPF:" + bilhete[i].usuario.cpf+"\n\n";

        }
        showMessageDialog(null, aux);




    }
}
