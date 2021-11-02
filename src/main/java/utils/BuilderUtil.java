package utils;

import builders.Category;
import builders.Pet;
import builders.Status;
import builders.Tag;
import java.util.List;


public class BuilderUtil {

    public  Pet buildFullDataPet(Integer id, String name, String photoUrls,
                                Integer categoryId, String categoryName, Integer tagId,
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


    public  Category buildCategory(Integer categoryId, String categoryName ){
        return Category.builder()
                .id(categoryId)
                .name(categoryName)
                .build();
    }

    public  Tag buildTags(Integer tagId, String tagName ){
        return Tag.builder()
                .id(tagId)
                .name(tagName)
                .build();
    }


}
