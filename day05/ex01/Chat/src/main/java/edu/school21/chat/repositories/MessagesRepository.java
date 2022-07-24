package edu.school21.chat.repositories;

import edu.school21.chat.models.Massage;

import java.util.Optional;

public interface MessagesRepository {
    Optional<Massage> findById(Long id);
}
