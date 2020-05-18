package ro.spet.pdg.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.spet.pdg.backend.entities.Teacher;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    List<Teacher> findByName(String name);

}
