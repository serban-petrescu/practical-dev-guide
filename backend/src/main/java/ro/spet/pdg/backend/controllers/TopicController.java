package ro.spet.pdg.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.spet.pdg.backend.dto.TopicDTO;
import ro.spet.pdg.backend.services.TopicManagementService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TopicController {
    private final TopicManagementService service;

    @GetMapping("/topics")
    public List<TopicDTO> listAll() {
        return service.listTopics();
    }

    @GetMapping("/topics/{id}")
    public TopicDTO readSingle(@PathVariable int id) {
        return service.readSingleTopic(id);
    }

    @PostMapping("/topics")
    public TopicDTO create(@RequestBody TopicDTO body) {
        return service.createTopic(body);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteSingle(@PathVariable int id) {
        service.deleteTopic(id);
    }

    @PutMapping("/topics/{id}")
    public TopicDTO updateSingle(@PathVariable int id, @RequestBody TopicDTO body) {
        return service.updateTopic(id, body);
    }
}
