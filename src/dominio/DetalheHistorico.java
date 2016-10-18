package dominio;

import java.util.Date;

public class DetalheHistorico {
	private Date dataHora;
	private String tipoOperacao;
	private double valor;
	private double saldo;
	
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Lançamento [dataHora=" + dataHora + ", tipoOperacao = "
				+ tipoOperacao + ", valor=" + valor + ", saldo=" + saldo + "]";
	}

}
