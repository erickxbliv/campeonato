package vai.foi;

public class Clubes{

    public String nome;
    public int pontos;
    public int saldo;

    public void ganhar(int saldo){

        this.pontos = this.pontos + 3;
        this.saldo = this.saldo + saldo;
    }

    public void empatar(){

        this.pontos = this.pontos + 1;

    }

    public void perder(int saldo){

        this.saldo = this.saldo + saldo;

    }
}