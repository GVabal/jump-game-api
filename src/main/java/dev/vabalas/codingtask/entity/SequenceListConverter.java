package dev.vabalas.codingtask.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

// Had issues with storing List to database, ended up with storing as a String to work around it
// so this class is not being used for now.
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
