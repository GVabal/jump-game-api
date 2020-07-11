package dev.vabalas.jumpGame.service;

import dev.vabalas.jumpGame.dto.SequenceDto;
import dev.vabalas.jumpGame.entity.Sequence;
import dev.vabalas.jumpGame.exception.EntityNotFoundException;
import dev.vabalas.jumpGame.repository.SequenceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static dev.vabalas.jumpGame.service.ServiceHelper.*;

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

    public Sequence findOne(Integer id) {
        return sequenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find sequence with id " + id));
    }

    public void deleteAll() {
        sequenceRepository.deleteAll();
    }
}
