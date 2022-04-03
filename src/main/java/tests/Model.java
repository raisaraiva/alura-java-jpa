package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Cliente;
import models.Conta;

import java.util.List;

public class Model {
	public static void test() throws Exception {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta();

		conta.setTitular("Leonardo");
		conta.setNumero(1234);
		conta.setAgencia(4321);
		conta.setSaldo(10.0);

		entityManager.getTransaction().begin();

		entityManager.persist(conta);

		entityManager.getTransaction().commit();

		Cliente cliente = new Cliente();

		cliente.setConta(conta);
		cliente.setEndereco("Rua do Ouvidor, 50");
		cliente.setNome(conta.getTitular());
		cliente.setProfissao("Professor");

		entityManager.getTransaction().begin();
		
		entityManager.persist(cliente);
		
		entityManager.getTransaction().commit();

		// busca as informações cadastradas

		List<Cliente> clienteList = entityManager.createQuery("select c from Cliente c order by c.nome", Cliente.class).getResultList();

		if (clienteList != null && clienteList.size() > 0) {
			Cliente primeiro = clienteList.get(0);

			System.out.println("Informações do primeiro cliente");
			System.out.println("Nome: " + primeiro.getNome());
			System.out.println("Endereço: " + primeiro.getEndereco());
			System.out.println("Profissão: " + primeiro.getProfissao());
			System.out.println("Agência: " + primeiro.getConta().getAgencia());
			System.out.println("Número: " + primeiro.getConta().getAgencia());
			System.out.println("Saldo: " + primeiro.getConta().getSaldo());
		}
	}
}

