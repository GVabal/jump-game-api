package dev.vabalas.jumpGame.controller;

import dev.vabalas.jumpGame.entity.Sequence;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class SequenceModelAssembler implements RepresentationModelAssembler<Sequence, EntityModel<Sequence>> {

    @Override
    public EntityModel<Sequence> toModel(Sequence sequence) {
        return EntityModel.of(sequence,
                linkTo(methodOn(SequenceController.class).one(sequence.getId())).withSelfRel(),
                linkTo(methodOn(SequenceController.class).all(Pageable.unpaged())).withRel("sequences")
        );
    }
}
