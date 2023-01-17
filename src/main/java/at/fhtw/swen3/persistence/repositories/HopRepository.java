package at.fhtw.swen3.persistence.repositories;


import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public interface HopRepository  extends JpaRepository<HopEntity, Long> {
    Optional<HopEntity> getFirstByCode(String code);
}
