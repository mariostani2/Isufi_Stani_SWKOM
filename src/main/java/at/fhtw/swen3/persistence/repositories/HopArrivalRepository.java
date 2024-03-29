package at.fhtw.swen3.persistence.repositories;


import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface HopArrivalRepository  extends JpaRepository<HopArrivalEntity, Long> {


    Optional<HopArrivalEntity> findFirstByParcelAndCodeAndVisited(ParcelEntity parcelEntity, String code, boolean b);
}
