package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		contactRepository.save(new Contact ("hassani","mohammed",df.parse("12/12/1998"),"ra@gmail.com",6612585,"hassan.png"));
		contactRepository.save(new Contact ("lina","lineed",df.parse("12/12/1998"),"ina@gmail.com",66152585,"oooo.png"));
		
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
		
	}

}
