package telas;
import dominio.Cliente;
import dominio.Conta;
import dominio.ContaCorrente;
import dominio.ContaPoupanca;

import java.util.Scanner;

public class Teste_Conta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Digite o Nome: ");
		String nome = keyboard.nextLine();
		
		System.out.println("Digite o CPF: ");
		String cpf = keyboard.nextLine();
		
		System.out.println("Digite a Agência: ");
		int ag = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("Digite a Conta: ");
		int conta = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("Digite o saldo inicial: ");
		double saldo = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.println("Digite o valor a creditar: ");
		double credito = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.println("Digite o valor a transferir: ");
		double transf = keyboard.nextDouble();
		keyboard.nextLine();
		
		keyboard.close();
		
		Cliente c1 = new Cliente(nome, cpf);
		Cliente c2 = new Cliente("Joao", "534.142.412-54");
		ContaCorrente cc1 = new ContaCorrente(ag, conta, saldo, c1);
		ContaPoupanca cc2 = new ContaPoupanca(1589, 20654, c2);
		
		System.out.println(cc1);
		System.out.println(cc2);
		
		cc1.setTaxaCPMF(0.05);
		cc1.creditar(credito);
		System.out.println(cc1.getSaldo());
		System.out.println(cc1.getTotalCPMF());
		
		cc1.transferir(cc2, transf);
		cc2.setTaxaJuros(0.15);
		cc2.aplicarJuros();
		
		//System.out.println(cc2);
		//System.out.println(cc1);
		System.out.println(cc1.getHistorico());
		System.out.println(cc2.getHistorico());
		
		
		
	}
	
}
