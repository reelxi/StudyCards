package com.Elbracht.StudyCards.Deck;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeckService {

    private final DeckRepository deckRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    public Deck getDeckById(UUID id) {
        return deckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Deck with ID " + id + " not found"));
    }

    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    public void deleteDeck(UUID id) {
        deckRepository.deleteById(id);
    }

}
