package org.pflb.vault.repository;

import org.pflb.vault.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByLogin(String login);
}
