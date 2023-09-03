package br.eti.save.rabbitpoc.model;


import java.io.Serializable;

public record UserData(Integer code, String name) implements Serializable {
}
