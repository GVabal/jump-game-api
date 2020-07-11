package dev.vabalas.jumpGame.repository;

import dev.vabalas.jumpGame.entity.Sequence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, Integer> {

    Sequence findByList(String list);

    boolean existsByList(String list);

    Page<Sequence> findAll(Pageable pageable);
}
