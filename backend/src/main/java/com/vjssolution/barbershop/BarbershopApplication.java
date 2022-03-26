package com.vjssolution.barbershop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vjssolution.barbershop.models.ClienteModel;
import com.vjssolution.barbershop.models.UserModel;
import com.vjssolution.barbershop.services.ClienteService;
import com.vjssolution.barbershop.services.UserService;

@SpringBootApplication
public class BarbershopApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserModel user1 = new UserModel(null, "maria", "maria@gmail.com", "49988995140");
		UserModel user2 = new UserModel(null, "josé", "jose@gmail.com", "49955663345");
		UserModel user3 = new UserModel(null, "pedro", "pedro@gmail.com", "49955669987");
		UserModel user4 = new UserModel(null, "joão", "joao@gmail.com", "49978963254");
		UserModel user5 = new UserModel(null, "carlos", "carlos@gmail.com", "49987589645");
		UserModel user6 = new UserModel(null, "'natalia", "natalia@gmail.com", "49988325648");
		UserModel user7 = new UserModel(null, "jurema", "jurema@gmail.com", "49966441122");

		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);
		userService.saveUser(user5);
		userService.saveUser(user6);
		userService.saveUser(user7);

		//LocalDate data = LocalDate.of(1995, Month.JANUARY, 1);
		ClienteModel cli1 = new ClienteModel(null,"jurema","Rua","Nereu Ramos",305,"Centro","Fraiburgo" ,"SC", "jurema@gmail.com","49966441122",  LocalDate.of(1995, Month.JANUARY, 11), LocalDateTime.now(ZoneId.of("UTC")));
		ClienteModel cli2 = new ClienteModel(null,"joão","Rua","Paulo Coelho",115,"Bela Vista","Fraiburgo" ,"SC", "joao@gmail.com","49966441122",  LocalDate.of(1974, Month.AUGUST, 18), LocalDateTime.now(ZoneId.of("UTC")));
		ClienteModel cli3 = new ClienteModel(null,"apulo","Avenida","João Marques Vieira",200,"Sâo José","Fraiburgo" ,"SC", "paulo@gmail.com","49966441122",  LocalDate.of(2015, Month.MAY, 21), LocalDateTime.now(ZoneId.of("UTC")));
		ClienteModel cli4 = new ClienteModel(null,"roberto","Rua","Padre Biagio Simonneti",400,"São Miguel","Fraiburgo" ,"SC", "robertogmail.com","49966441122",  LocalDate.of(2000, Month.NOVEMBER, 23), LocalDateTime.now(ZoneId.of("UTC")));
		ClienteModel cli5 = new ClienteModel(null,"mario","Avenida","Curitibanos",82,"Jardim América","Fraiburgo" ,"SC", "mario@gmail.com","49966441122",  LocalDate.of(1989, Month.JULY, 31), LocalDateTime.now(ZoneId.of("UTC")));
		
		clienteService.salvarCliente(cli1);
		clienteService.salvarCliente(cli2);
		clienteService.salvarCliente(cli3);
		clienteService.salvarCliente(cli4);
		clienteService.salvarCliente(cli5);
		/*
		 * Category cat1 = new Category(null, "Electronics"); Category cat2 = new
		 * Category(null, "Books");
		 * 
		 * Product p1 = new Product(null, "TV", 2200.00, cat1); Product p2 = new
		 * Product(null, "Domain Driven Design", 120.00, cat2); Product p3 = new
		 * Product(null, "PS5", 2800.00, cat1); Product p4 = new Product(null, "Docker",
		 * 100.00, cat2);
		 * 
		 * cat1.getProducts().addAll(Arrays.asList(p1, p3));
		 * cat2.getProducts().addAll(Arrays.asList(p2, p4));
		 * 
		 * categoryRepository.save(cat1); categoryRepository.save(cat2);
		 * 
		 * productRepository.save(p1); productRepository.save(p2);
		 * productRepository.save(p3); productRepository.save(p4);
		 */
	}
}
