package dev.vabalas.codingtask.controller;

import dev.vabalas.codingtask.dto.MultiSequenceDto;
import dev.vabalas.codingtask.dto.SequenceDto;
import dev.vabalas.codingtask.entity.Sequence;
import dev.vabalas.codingtask.service.SequenceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "sequences")
public class SequenceController {

    private final SequenceService sequenceService;
    private final SequenceModelAssembler assembler;
    private final PagedResourcesAssembler<Sequence> pagedAssembler;

    public SequenceController(SequenceService sequenceService,
                              SequenceModelAssembler assembler,
                              PagedResourcesAssembler<Sequence> pagedAssembler) {
        this.sequenceService = sequenceService;
        this.assembler = assembler;
        this.pagedAssembler = pagedAssembler;
    }

    @GetMapping
    public PagedModel<EntityModel<Sequence>> all(Pageable pageable) {
        Page<Sequence> sequences = sequenceService.findAll(pageable);
        return pagedAssembler.toModel(sequences, assembler);
    }

    @GetMapping(path = "/{id}")
    public EntityModel<Sequence> one(@PathVariable Integer id) {
        return assembler.toModel(sequenceService.findOne(id));
    }

    @PostMapping
    public Sequence testOne(@RequestBody @Validated SequenceDto sequenceDto) {
        return sequenceService.testSequence(sequenceDto);
    }

    @PostMapping(path = "/batch")
    public void testMany(@RequestBody @Validated MultiSequenceDto multiSequenceDto) {
        // Due to issues with MultiSequenceDto this was not implemented.
    }

    @DeleteMapping
    public void deleteAll() {
        sequenceService.deleteAll();
    }
}
