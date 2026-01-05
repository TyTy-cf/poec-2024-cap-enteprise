package fr.kevin.cap_enterprise.entity;

import fr.kevin.cap_enterprise.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Game implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private LocalDate publishedAt;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String name;

    private String slug;

    @OneToMany(mappedBy = "game")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    private List<Platform> platforms = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private Classification classification;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(nullable = false)
    private BusinessModel businessModel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Moderator moderator;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Publisher publisher;

    public void addPlatform(Platform platform) {
        if (!platforms.contains(platform)) {
            platforms.add(platform);
        }
    }

    @Override
    public String getField() {
        return name;
    }
}