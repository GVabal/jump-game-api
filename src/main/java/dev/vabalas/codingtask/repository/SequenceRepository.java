package dev.vabalas.codingtask.repository;

import dev.vabalas.codingtask.entity.Sequence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, Integer> {

    Sequence findByList(String list);

    boolean existsByList(String list);

    Page<Sequence> findAll(Pageable pageable);

    List<Sequence> findAll();
}
