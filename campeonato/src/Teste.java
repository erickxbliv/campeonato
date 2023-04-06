import java.util.Scanner;
import vai.Campeonato;

public class Teste {
    public static void main(String[] args){

        Campeonato futebol = new Campeonato();
        int qtd_times = -1;
	    Scanner myObj = new Scanner(System.in);

        while(qtd_times % 2 != 0){
            System.out.print("Quantos times vc deseja que joguem o campeonato? \nEscreva o valor (par) a seguir: ");
            qtd_times = myObj.nextInt();
        }

        System.out.println("Voce deseja escolher o nome dos times? Se sim, digite \"sim\" ou \"1\"");
        String buffer = myObj.nextLine(), resp = myObj.nextLine(), nome;
        resp.toLowerCase();

        int i = 1;
        if(resp.equals("sim") || resp.equals("1") || resp.equals("yes") || resp.equals("ss") || resp.equals("s") || resp.equals("si")){

            while(i <= qtd_times){

                System.out.print("\nNome do Clube " + i + ": " );
                nome = myObj.nextLine();
                //buffer = myObj.nextLine();
                futebol.gerar(nome);
                i++;
            }
        }else{

            while(i <= qtd_times){
                nome = "Clube_" + i;
                futebol.gerar(nome);
                i++;
            }
        }



        

        

    

        futebol.jogar_campeonato();
        futebol.getclassificacao();
        futebol.getcampeao();
        myObj.close();
    }
}





