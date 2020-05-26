package ro.spet.pdg.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.spet.pdg.backend.dto.TopicDTO;
import ro.spet.pdg.backend.entities.Topic;
import ro.spet.pdg.backend.exceptions.NotFoundException;
import ro.spet.pdg.backend.repositories.TeacherRepository;
import ro.spet.pdg.backend.repositories.TopicRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
public class TopicManagementService {
    private final TopicRepository repository;
    private final TeacherRepository teacherRepository;

    public List<TopicDTO> listTopics() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(TopicDTO::of)
                .collect(Collectors.toList());
    }

    public TopicDTO readSingleTopic(int id) {
        return repository.findById(id)
                .map(TopicDTO::of)
                .orElseThrow(NotFoundException::new);
    }

    public TopicDTO createTopic(TopicDTO input) {
        Topic topic = input.toEntity();
        topic.setTeacher(teacherRepository.findById(1).orElseThrow(NotFoundException::new));
        return TopicDTO.of(repository.save(topic));
    }

    public void deleteTopic(int id) {
        repository.deleteById(id);
    }

    public TopicDTO updateTopic(int id, TopicDTO input) {
        Topic topic = repository.findById(id).orElseThrow(NotFoundException::new);
        input.copyToEntity(topic);
        repository.save(topic);
        return TopicDTO.of(topic);
    }
}
