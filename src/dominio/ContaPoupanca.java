package dominio;

public class ContaPoupanca extends Conta {
	
	private double taxaJuros;

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	public void aplicarJuros (){
		this.setSaldo(this.getSaldo() + (this.getSaldo() * taxaJuros));
	}
	
	public ContaPoupanca (int agencia, int numero, Cliente cliente){
		super(agencia, numero, cliente);
	}
	
	public ContaPoupanca (int agencia, int numero, double valor, Cliente cliente){
		super(agencia, numero, valor, cliente);
	}
}
