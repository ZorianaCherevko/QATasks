package builders;

import groovy.transform.builder.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pet {

    private Category category;
    private Integer id;
    private String name;
    private List<String> photoUrls;
    private Status status;
    private List<Tag> tags;


}

