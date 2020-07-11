package dev.vabalas.jumpGame.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class SequenceListConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> integerList) {
        StringBuilder sb = new StringBuilder();
        for (Integer i: integerList) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public List<Integer> convertToEntityAttribute(String string) {
        String[] splitString = string.split(",");
        List<Integer> integerList = new ArrayList<>();
        for (String element : splitString) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }

}
