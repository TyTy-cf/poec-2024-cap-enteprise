package fr.kevin.cap_enterprise.entity;

import fr.kevin.cap_enterprise.entity.interfaces.NomenclatureInterface;
import fr.kevin.cap_enterprise.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class BusinessModel implements
        SluggerInterface,
        NomenclatureInterface
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String slug;

    @OneToMany(mappedBy = "businessModel")
    private List<Game> games = new ArrayList<>();

    @Override
    public String getField() {
        return name;
    }
}