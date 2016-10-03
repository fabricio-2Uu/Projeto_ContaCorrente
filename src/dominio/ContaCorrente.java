package dominio;

public class ContaCorrente extends Conta{

	private double taxaCPMF;
	private double totalCPMF;
	
	public double getTaxaCPMF() {
		return taxaCPMF;
	}
	public void setTaxaCPMF(double taxaCPMF) {
		this.taxaCPMF = taxaCPMF;
	}
	public double getTotalCPMF() {
		return totalCPMF;
	}
	public void setTotalCPMF(double totalCPMF) {
		this.totalCPMF = totalCPMF;
	}
	
	public void debitar(double valor){
		if (valor >= 0)
			if (valor <= this.getSaldo()){
				double cpmf = valor * taxaCPMF;
				this.setSaldo(this.getSaldo() - valor - cpmf);
				this.totalCPMF += cpmf;
			}
			else
				throw new RuntimeException("Erro: Saldo insuficiente para realizar débito.");
		else
			throw new RuntimeException("Erro: Valor a ser debitado deve ser positivo.");
	}
	
	public ContaCorrente (int agencia, int numero, Cliente cliente){
		super(agencia, numero, cliente);
	}
	
	public ContaCorrente (int agencia, int numero, double valor, Cliente cliente){
		super(agencia, numero, valor, cliente);
	}
}
