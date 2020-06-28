package dev.vabalas.codingtask.dto;

import com.sun.istack.NotNull;
import net.minidev.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class MultiSequenceDto {

    private List<List<Integer>> lists = new ArrayList<>();

    protected MultiSequenceDto() { }

    public MultiSequenceDto(@NotNull JSONObject jsonObject){
        // Had issues with parsing JSON array into list of sequences,
        // therefore cannot accept batch of arrays to compute many in one request for now.
    }

    public List<List<Integer>> getLists() {
        return lists;
    }

    public void setLists(List<List<Integer>> lists) {
        this.lists = lists;
    }

}
