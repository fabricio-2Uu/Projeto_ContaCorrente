package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta {

	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
	private List<DetalheHistorico> extrato = new ArrayList<DetalheHistorico>();
	
	protected void registraHistorico(Date data, String tipo, double valor, double saldo) {
		DetalheHistorico registro = new DetalheHistorico();
		registro.setDataHora(data);
		registro.setSaldo(saldo);
		registro.setTipoOperacao(tipo);
		registro.setValor(valor);
		extrato.add(registro);
	}
	
	public List<DetalheHistorico> getHistorico(){
		return extrato;
	}
	
	public List<DetalheHistorico> getHistorico(Date inicio, Date fim){
		List<DetalheHistorico> resumo = new ArrayList<DetalheHistorico>();
		
		for (DetalheHistorico registro: extrato)
			if (registro.getDataHora().getTime() >= inicio.getTime() && registro.getDataHora().getTime() <= inicio.getTime()){
				resumo.add(registro);
			}
		return resumo;
	}
	
	public int quantidadeDepositos(Date inicio, Date fim){
		int quantidade = 0;
		
		for (DetalheHistorico registro: extrato)
			if (registro.getTipoOperacao().equals("crédito")){
				quantidade += 1;
			}
		
		return quantidade;
	}
	
	public double totalDepositos(Date inicio, Date fim){
		double somatorio = 0;
		
		for (DetalheHistorico registro: extrato)
			if (registro.getTipoOperacao().equals("crédito")){
				somatorio += registro.getValor();
			}
		
		return somatorio;
	}
	
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
		if (valor >= 0){
			this.saldo += valor;
			Date data = new Date();
			String tipo = "crédito";
			this.registraHistorico(data, tipo, valor, saldo);
		}
		else
			throw new RuntimeException("Erro: Valor a ser creditado deve ser positivo.");
	}
	
	public void debitar(double valor){
		if (valor >= 0)
			if (valor <= this.saldo){
				this.saldo -= valor;
				Date data = new Date();
				String tipo = "débito";
				this.registraHistorico(data, tipo, (valor*-1), saldo);
			}
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
				
				Date data = new Date();
				String tipo = "transferência";
				this.registraHistorico(data, tipo, (valor*-1), this.saldo);
				conta.registraHistorico(data, tipo, valor, conta.getSaldo());
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
