package fr.kevin.cap_enterprise.DTO;

import fr.kevin.cap_enterprise.entity.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameDTO {

    @NotBlank
    private String description;

    @NotBlank
    private String publishedAt;

    @NotBlank
    private String name;

    @NotEmpty
    private List<Platform> platforms;

    @NotNull
    private Classification classification;

    @NotNull
    private Genre genre;

    @NotNull
    private BusinessModel businessModel;

    @NotNull
    private Publisher publisher;

}