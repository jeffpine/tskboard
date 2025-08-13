package org.pinedev.tskboard.persistence.entity;
import lombok.Data;

@Data
public class BoardColumnEntity {

    private Long id;
    private String name;
    private int order;
    private BoardColumnkindEnum kind;
    private BoardEntity board = new BoardEntity();

}
