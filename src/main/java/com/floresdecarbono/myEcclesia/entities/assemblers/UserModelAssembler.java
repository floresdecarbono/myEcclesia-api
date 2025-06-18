package com.floresdecarbono.myEcclesia.entities.assemblers;

import com.floresdecarbono.myEcclesia.controllers.UserController;
import com.floresdecarbono.myEcclesia.entities.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.UUID;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User entity) {
        UUID id = entity.getId();
        Link self = linkTo(methodOn(UserController.class).findOne(id)).withSelfRel();
        Link all = linkTo(methodOn(UserController.class).findAll()).withRel("users");
        Link update = linkTo(methodOn(UserController.class).update(id, null)).withRel("update");
        Link delete = linkTo(methodOn(UserController.class).delete(id)).withRel("delete");

        return EntityModel.of(entity, self, all, update, delete);
    }
}
