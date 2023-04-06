package vai;

import java.util.ArrayList;
import vai.foi.Clubes;
import java.util.Random;

public class Campeonato{

    ArrayList<Clubes> times = new ArrayList<Clubes>();

    public void gerar(String mencionado){

        Clubes geracao = new Clubes();
        geracao.nome = mencionado;
        geracao.saldo = 0;
        geracao.pontos = 0;

        this.times.add(geracao);
        //System.out.println(mencionado);
        
    }


    public void jogar_campeonato(){

        //ArrayList<Clubes> competidores = new ArrayList<Clubes>(this.times);
        ArrayList<Clubes> competidores = new ArrayList<Clubes>();

        int tamanho = this.times.size();
        int i = 0, j = 0;

        for(i = 0; i < (tamanho-1); i++){

            for(j = (i+1); j < tamanho; j++){
                competidores.add(this.times.get(i));
                competidores.add(this.times.get(j));
                //System.out.println(i + "  e  " + j);
            }
        }

        while(tamanho >= 2){

            jogar_partida(competidores.get(0),competidores.get(1));
            jogar_partida(competidores.get(1),competidores.get(0));
            competidores.remove(0);
            competidores.remove(0);
            tamanho = competidores.size();
        }

        //competidores = (ArrayList<Clubes>)this.times.clone();
    }

    public void jogar_partida(Clubes x, Clubes y){

        Random gerador = new Random();
        int ataque_1 = gerador.nextInt(6), ataque_2 = gerador.nextInt(6), saldo_x, saldo_y; 

        System.out.println(x.nome + " vs " + y.nome);
        System.out.println("       " + ataque_1 + " x " + ataque_2 + "\n");

        saldo_x = (ataque_1 - ataque_2);
        saldo_y = (ataque_2 - ataque_1);

        if(ataque_1 == ataque_2){

            x.empatar();
            y.empatar();

        }else if(ataque_1 > ataque_2){
            
            x.ganhar(saldo_x);
            y.perder(saldo_y);

        }else{

            y.ganhar(saldo_y);
            x.perder(saldo_x);

        }

    }

    public void getclassificacao(){

        bubble_sort((this.times.size()-1));

        for(int i = 0; i < this.times.size(); i++){

            System.out.println("Em " + (this.times.size()-i) + " lugar: " + this.times.get(i).nome + " com " + this.times.get(i).pontos + " pontos e " + this.times.get(i).saldo + " gols! ");

        }


    }


    public void bubble_sort(int tam){

        if(tam < 1) return; 
        int i;
        for (i=0; i < tam; i++){

            if (this.times.get(i).pontos > this.times.get(i+1).pontos){
   
                Clubes backup = this.times.get(i);
                Clubes novo = this.times.get(i+1);
                this.times.set(i,novo);
                this.times.set(i+1,backup);

            }else if(this.times.get(i).pontos == this.times.get(i+1).pontos){

                if(this.times.get(i).saldo > this.times.get(i+1).saldo){

                    Clubes backup = this.times.get(i);
                    Clubes novo = this.times.get(i+1);
                    this.times.set(i,novo);
                    this.times.set(i+1,backup);

                }
            }
        } 

        bubble_sort(tam-1); 
    }

    public void getcampeao(){

        System.out.println("\n\nParabens " + this.times.get((this.times.size()-1)).nome + " pela sua vitoria!!\n\n");
    }

}