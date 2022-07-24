package edu.school21.chat.repositories;

import edu.school21.chat.models.Massage;

import javax.sql.DataSource;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Optional<Massage> findById(Long id) {
        return Optional.empty();
    }
}
