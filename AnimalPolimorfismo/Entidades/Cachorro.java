package AnimalPolimorfismo.Entidades;

public class Cachorro extends Animal{
    public Cachorro(String nome, String cor, double peso) {
        super(nome, cor, peso);
    }

    @Override
    public String Correr() {
        return "Os cachorros atingem a velocidade de 30 km/h";
    }

    public String Alimentar() {
        return "Os cachorros se alimentam de racao";
    }

    public String Dormir() {
        return "Os cachorros dormem 8 horas por dia";
    }

    public String EmitirSom() {
        return "O som emitido pelos cachorros e: au-au-au";
    }

    public String toString() {
        return "TIPO: CACHORRO\n"
                +getNome()+" | "+getCor()+" | "+getPeso()+"kg\n"+
                Correr()+"\n"+Alimentar()+"\n"+EmitirSom()+"\n"+Dormir()+"\n";
    }
}
