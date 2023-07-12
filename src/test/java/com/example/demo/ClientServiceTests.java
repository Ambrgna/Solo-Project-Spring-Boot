package com.example.demo;

import com.genspark.SpringBootdemoApplication.Entity.Client;
import com.genspark.SpringBootdemoApplication.Service.ClientService;
import com.genspark.SpringBootdemoApplication.SpringBootdemoApplication;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringBootdemoApplication.class)
class ClientServiceTests {
	private List<String> list;
	private Client c;
	private int[] canView=new int[1];
	private int userid;
	private int clientid;
	@Autowired
	private ClientService clientService;

	public ClientServiceTests() {
		canView[0]=-1;
		userid=0;
	}

	@BeforeEach
	void init() {
		System.out.println("startup");
		c = new Client(userid, "test client", "", true, canView, "", null);
		c = clientService.addClient(c);
		clientid =c.getClientId();
	}
	@AfterEach
	void after() {
		System.out.println("deleting");
		clientService.deleteClientById(c.getClientId());
	}
	@Test
	void testGetAllClients() {
		List<Client> clients = clientService.getAllClients();
		boolean returnStatment= false;
		for (Client client:clients) {
			if (c.toString().equals(client.toString())){
				returnStatment=true;
			}
		}
		assertTrue(returnStatment);
	}
	@Test
	void testGetClientsByUserId() {
		List<Client> clients = clientService.getAllByUserId(userid);
		boolean returnStatment= false;
		for (Client client:clients) {
			if (c.toString().equals(client.toString())){
				returnStatment=true;
			}
		}
		assertTrue(returnStatment);
	}
	@Test
	void testGetClientById() {
		Client testClient = clientService.getClientById(clientid);
		boolean returnStatment= false;

		if (c.toString().equals(testClient.toString())){
			returnStatment=true;
		}

		assertTrue(returnStatment);
	}
	@Test
	void testAddClient() {
		Client testClient = new Client(userid, "test client", "", true, canView, "", null);
		testClient = clientService.addClient(testClient);

		Client getClient = clientService.getClientById(testClient.getClientId());
		boolean returnStatment= false;

		if (getClient.toString().equals(testClient.toString())){
			returnStatment=true;
		}

		clientService.deleteClientById(testClient.getClientId());
		assertTrue(returnStatment);
	}
	@Test
	void testUpdateClient() {
		String name = "updateClient";
		Client updateClient = new Client(c.getClientId(), 0, name, "", true, canView, "", null);

		clientService.updateClient(updateClient);

		Client getClient = clientService.getClientById(c.getClientId());

		assertEquals(name,getClient.getName());
	}
	@Test
	void testDeleteClientById() {

		clientService.disableClientById(c.getClientId());

		Client getClient = clientService.getClientById(c.getClientId());

		assertEquals(true,getClient.isDisabled());
	}
}
