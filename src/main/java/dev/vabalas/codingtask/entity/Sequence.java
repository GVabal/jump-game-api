package dev.vabalas.codingtask.entity;

import javax.persistence.*;

@Entity
@Table(name = "sequences")
public class Sequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "list")
    private String list;

    @Column(name = "winnable")
    private boolean winnable;

    @Column(name = "most_efficient_path")
    private String mostEfficientPath;

    protected Sequence() { }

    public Sequence(String list, boolean winnable, String mostEfficientPath) {
        this.list = list;
        this.winnable = winnable;
        this.mostEfficientPath = mostEfficientPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isWinnable() {
        return winnable;
    }

    public void setWinnable(boolean winnable) {
        this.winnable = winnable;
    }

    public String getMostEfficientPath() {
        return mostEfficientPath;
    }

    public void setMostEfficientPath(String mostEfficientPath) {
        this.mostEfficientPath = mostEfficientPath;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

}
