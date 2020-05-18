package ro.spet.pdg.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.spet.pdg.backend.entities.Teacher;
import ro.spet.pdg.backend.repositories.TeacherRepository;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner onStart(TeacherRepository repository) {
        return args -> {
            System.out.println("By name:");
            System.out.println(repository.findByName("Flor Lovat"));
            System.out.println("All:");
            System.out.println(repository.findAll());
            System.out.println("By id:");
            System.out.println(repository.findById(5));
            System.out.println("By id not found:");
            System.out.println(repository.findById(111));

            Teacher serban = new Teacher();
            serban.setName("Serban Petrescu");
            System.out.println(repository.save(serban));

            repository.deleteAll(repository.findByName("Serban Petrescu"));

            Teacher flor = repository.findById(11).orElseThrow(RuntimeException::new);
            flor.setName("Bla");
            repository.save(flor);
            System.out.println(repository.findById(11));
        };
    }

}
