package hu.unideb.inf.springdatafx_cs8;

import hu.unideb.inf.springdatafx_cs8.model.Person;
import hu.unideb.inf.springdatafx_cs8.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.LocaleResolver;

import java.time.LocalDate;

@SpringBootApplication
public class SpringDataFxCs8Application implements CommandLineRunner {


    private final LocaleResolver localeResolver;

    public SpringDataFxCs8Application(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataFxCs8Application.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        /*Person person = new Person();
        person.setName("Végh Béla");
        person.setDateOfBirth(LocalDate.of(2004,11,12));*/

        Person person = Person.builder()
                            .name("Cserepes Virág")
                            .dateOfBirth(LocalDate.of(2002,11,12))
                        .build();

        personRepository.save(person);
    }

    public void printData(){
        System.out.println("Printing on backend...");
    }

    public Person getPerson(){
        Person person = personRepository.findAll().get(0);
        return person;
    }
}
