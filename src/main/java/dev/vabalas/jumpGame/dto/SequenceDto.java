package dev.vabalas.jumpGame.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SequenceDto {

    private List<Integer> list = new ArrayList<>();

    protected SequenceDto() { }

    public SequenceDto(@NotNull JSONObject jsonObject) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.list = mapper.readValue(jsonObject.getAsString("list"), new TypeReference<>(){});
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
