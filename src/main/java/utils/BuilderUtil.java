package utils;

import builders.*;

import java.util.Date;
import java.util.List;


public class BuilderUtil {

    public  Pet buildFullDataPet(int id, String name, String photoUrls,
                                int categoryId, String categoryName, int tagId,
                                 String tagName, Status status ){
        return Pet.builder()
                .id(id)
                .name(name)
                .photoUrls(List.of(photoUrls))
                .category(buildCategory(categoryId, categoryName))
                .tags(List.of(buildTags(tagId, tagName)))
                .status(status)
                .build();
    }


    public  Category buildCategory(int categoryId, String categoryName ){
        return Category.builder()
                .id(categoryId)
                .name(categoryName)
                .build();
    }

    public  Tag buildTags(int tagId, String tagName ){
        return Tag.builder()
                .id(tagId)
                .name(tagName)
                .build();
    }

    public Order buildOrder(int orderId, int petId, int quantity, Date shipDate,
                            OrderStatus orderStatus, boolean complete){
        return Order.builder()
                .id(orderId)
                .petId(petId)
                .quantity(quantity)
                .shipDate(shipDate)
                .orderStatus(orderStatus)
                .complete(complete)
                .build();

    }


}
