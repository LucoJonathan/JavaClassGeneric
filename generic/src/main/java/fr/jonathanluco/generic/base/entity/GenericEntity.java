package fr.jonathanluco.generic.base.entity;

import java.io.Serializable;

public interface GenericEntity<I> extends Serializable
    {

        I getId();

    }
