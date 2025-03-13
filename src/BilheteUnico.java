import java.util.Random;

public class BilheteUnico {

    double saldo;
    long numero;
    //static defini que ela é uma variável da classe e não do objeto
    static final double TARIFA = 5.20;
    Usuario usuario;

    public BilheteUnico(String nome, long cpf, String perfil ){
        Random random = new Random();
        numero = random.nextLong(1000, 10000);

        usuario=new Usuario(cpf, nome, perfil);
    }
    //método para carregar o bilhete

    public double carregar(double valor){

        saldo += valor;

        return saldo;
    }
    //método para consultar o saldo do bilhete

    public double consultarSaldo(){
        return saldo;
    }

    //método para passar na catraca
    public String passarNaCatraca(){
        double debito = TARIFA/2;
        if(usuario.perfil.equalsIgnoreCase("comum")){
            debito=TARIFA;
        }
        if(saldo >= debito){
            saldo =-debito;
            return "catraca liberada";
        }
        return "Saldo insufuciente";
    }
}
