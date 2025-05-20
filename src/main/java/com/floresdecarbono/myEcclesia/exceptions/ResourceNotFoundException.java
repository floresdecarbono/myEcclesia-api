package com.floresdecarbono.myEcclesia.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(UUID id) {
        super("Resource with ID " + id + " not found.");
    }
}
