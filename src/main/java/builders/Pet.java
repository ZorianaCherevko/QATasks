package builders;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pet {

    private Category category;
    private Integer id;
    private String name;
    private String photoUrl;
    private Status status;
    private List<Tag> tags;


}

