package builders;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {


    private Integer id;
    private String name;


}