package at.fhtw.swen3.persistence.repositories;


import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public interface HopRepository  extends JpaRepository<HopEntity, Long> {
    Optional<HopEntity> getFirstByCode(String code);

    @Query(value = "SELECT *,0 as clazz_\n" +
            "            FROM hop \n" +
            "            JOIN geo_coordinate ON hop.location_coordinates_id = geo_coordinate.id\n" +
            "            ORDER BY ST_Distance(ST_MakePoint(CAST(geo_coordinate.lon AS float8), CAST(geo_coordinate.lat AS float8)), ST_MakePoint(:lon, :lat)) \n" +
            "            LIMIT 1; ", nativeQuery = true)
    HopEntity findNearestHop(@Param("lat") Double lat, @Param("lon") Double lon);

//    @Query(value = "SELECT *, 0 AS clazz_ " +
//            "FROM hop  " +
//            "         JOIN warehouse_next_hops ON hop.id = warehouse_next_hops.warehouse_entity_id " +
//            "WHERE (warehouse_next_hops.next_hops_id = :currentId)" +
//            ";", nativeQuery = true)
//    List<HopEntity> getPreviousHops(@Param("currentId") Long currentId);
}
