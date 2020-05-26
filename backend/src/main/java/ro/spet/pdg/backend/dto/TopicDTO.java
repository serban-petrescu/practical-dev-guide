package ro.spet.pdg.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.spet.pdg.backend.entities.Topic;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicDTO {
    private int id;
    private String name;
    private BigDecimal minFinalScore;
    private int minAttendances;
    private String finalScoreFormula;

    public static TopicDTO of(Topic entity) {
        return TopicDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .finalScoreFormula(entity.getFinalScoreFormula())
                .minAttendances(entity.getMinAttendances())
                .minFinalScore(entity.getMinFinalScore())
                .build();
    }

    public Topic toEntity() {
        Topic result = new Topic();
        this.copyToEntity(result);
        return result;
    }

    public void copyToEntity(Topic topic) {
        topic.setName(name);
        topic.setFinalScoreFormula(finalScoreFormula);
        topic.setMinAttendances(minAttendances);
        topic.setMinFinalScore(minFinalScore);
    }
}
