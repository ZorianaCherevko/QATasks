package builders;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private Integer id;
    private String name;

}