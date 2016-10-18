package dominio;

import java.util.Date;

public class ContaPoupanca extends Conta {
	
	private double taxaJuros;

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	public void aplicarJuros (){
		double juros = (this.getSaldo() * taxaJuros);
		this.setSaldo(this.getSaldo() + juros);
		
		Date data = new Date();
		String tipo = "Juros";
		super.registraHistorico(data, tipo, juros, this.getSaldo());
	}
	
	public ContaPoupanca (int agencia, int numero, Cliente cliente){
		super(agencia, numero, cliente);
	}
	
	public ContaPoupanca (int agencia, int numero, double valor, Cliente cliente){
		super(agencia, numero, valor, cliente);
	}
}
