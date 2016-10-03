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
		
		this.setAgencia(agencia);
		this.setNumero(numero);
		this.setCliente(cliente);
	}
	
	public ContaPoupanca (int agencia, int numero, double valor, Cliente cliente){
		
		this.setAgencia(agencia);
		this.setNumero(numero);
		this.setSaldo(valor);
		this.setCliente(cliente);
	}
}
