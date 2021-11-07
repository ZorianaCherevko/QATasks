package builders;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private OrderStatus orderStatus;
    private boolean complete;

}
