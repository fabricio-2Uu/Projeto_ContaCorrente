package dominio;

public abstract class Conta {

	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
	
	public Conta(){
		
		this.agencia = 0;
		this.numero = 0;
		this.setCliente(null);
	}
	
	public Conta (int agencia, int numero, Cliente cliente){
		
		this.agencia = agencia;
		this.numero = numero;
		this.setCliente(cliente);
	}
	
	public Conta (int agencia, int numero, double valor, Cliente cliente){
		
		this.agencia = agencia;
		this.numero = numero;
		this.setSaldo(valor);
		this.setCliente(cliente);
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void creditar(double valor){
		if (valor >= 0)
			this.saldo += valor;
		else
			throw new RuntimeException("Erro: Valor a ser creditado deve ser positivo.");
	}
	
	public void debitar(double valor){
		if (valor >= 0)
			if (valor <= this.saldo)
				this.saldo -= valor;
			else
				throw new RuntimeException("Erro: Saldo insuficiente para realizar débito.");
		else
			throw new RuntimeException("Erro: Valor a ser debitado deve ser positivo.");
	}
	
	public void transferir(Conta conta, double valor){
		if (valor >= 0)
			if (valor <= this.saldo){
				this.saldo -= valor;
				conta.creditar(valor);
			}
			else
				throw new RuntimeException("Erro: Saldo insuficiente para realizar débito.");
		else
			throw new RuntimeException("Erro: Valor a ser debitado deve ser positivo.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", cliente=" + getCliente().getNome() + ", CPF=" + getCliente().getCpf() + ", getAgencia()="
				+ getAgencia() + ", getNumero()=" + getNumero() + ", getSaldo()=" + getSaldo() + "]";
	}	
	
	
	
}
