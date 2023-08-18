package com.Elbracht.StudyCards.Card;

import com.Elbracht.StudyCards.Deck.Deck;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    @NotNull
    private Date created;
    @NotNull
    private String question;
    @NotNull
    private String expectedAnswer;
    private int repeated;
    private int correctAnswer;
    private int falseAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deck_id", nullable=false)
    private Deck deck;
}