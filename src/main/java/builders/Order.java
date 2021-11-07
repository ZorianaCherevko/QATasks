package builders;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Order {

    private int id;
    private int petId;
    private int quantity;
    private Date shipDate;
    private OrderStatus orderStatus;
    private boolean complete;

}
