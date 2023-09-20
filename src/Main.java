import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o límite do cartão");
        double limite = input.nextDouble();
        Cartao cartao = new Cartao(limite);

        int cont = 0;

        while(cont != 1){
            System.out.println("Digite o produto a ser comprado");
            String nome = input.next();
            System.out.println("------------------------------------");

            System.out.println("Digite o valor do produto");
            double valor = input.nextDouble();
            System.out.println("------------------------------------");

            Compra compra = new Compra(nome, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para continuar e 1 para sair");
                cont = input.nextInt();
            } else{
                System.out.println("Saldo insuficiente");
                cont = 1;
            }
            System.out.println("------------------------------------");
            System.out.println("COMPRAS REALIZADAS: \n");
            Collections.sort(cartao.getCompras());
            for(Compra c : cartao.getCompras()){
                System.out.println(c.getNome() + "-" + c.getValor());
            }
            System.out.println("------------------------------------");
            System.out.println("\nSaldo do cartão: "+cartao.getSaldo());
        }
    }
}