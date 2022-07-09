package VeiculoPolimorfismo.Entidades;

public class Carro extends Veiculo{
    public Carro(String modelo, String cor, String tipoCombustivel, double valor) {
        super(modelo, cor, tipoCombustivel, valor);
    }

    @Override
    public double calulaIPVA() {
        return getValor() * 0.04;
    }

    @Override
    public String toString() {
        return "Carro{"+getModelo()+", "+getCor()+", "+getTipoCombustivel()+", R$"+getValor()+", R$"+getIpva()+"}";
    }
}
