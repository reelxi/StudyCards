package com.Elbracht.StudyCards.Card;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(UUID id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Card with ID " + id + " not found"));
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public void deleteCard(UUID id) {
        cardRepository.deleteById(id);
    }
}
