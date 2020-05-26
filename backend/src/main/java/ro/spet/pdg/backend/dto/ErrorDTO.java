package ro.spet.pdg.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.spet.pdg.backend.exceptions.NotFoundException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String type;
    private String message;

    public static ErrorDTO of(NotFoundException exception) {
        return new ErrorDTO("not_found", exception.getMessage());
    }
}
