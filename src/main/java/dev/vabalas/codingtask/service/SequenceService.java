package dev.vabalas.codingtask.service;

import dev.vabalas.codingtask.dto.SequenceDto;
import dev.vabalas.codingtask.entity.Sequence;
import dev.vabalas.codingtask.exception.EntityNotFoundException;
import dev.vabalas.codingtask.repository.SequenceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static dev.vabalas.codingtask.service.ServiceHelper.*;

import java.util.List;

@Service
public class SequenceService {

    private final SequenceRepository sequenceRepository;

    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public Sequence testSequence(SequenceDto sequenceDto) {
        if (sequenceRepository.existsByList(listToString(sequenceDto.getList()))) {
            return sequenceRepository.findByList(listToString(sequenceDto.getList()));
        }
        boolean winnable = listIsWinnable(sequenceDto.getList());
        return sequenceRepository.save(new Sequence(listToString(sequenceDto.getList()),
                                        winnable,
                                        mostEfficientPathForList(winnable, sequenceDto.getList())));
    }

    public Page<Sequence> findAll(Pageable pageable) {
        return sequenceRepository.findAll(pageable);
    }

    public List<Sequence> findAll() {
        return sequenceRepository.findAll();
    }

    public Sequence findOne(Integer id) {
        return sequenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find sequence with id " + id));
    }

    public void deleteAll() {
        sequenceRepository.deleteAll();
    }
}
