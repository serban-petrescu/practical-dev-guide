package ro.spet.pdg.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.spet.pdg.backend.entities.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
