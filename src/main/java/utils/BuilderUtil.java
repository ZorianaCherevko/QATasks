package utils;

import builders.Category;
import builders.Pet;
import builders.Status;
import builders.Tag;

import java.util.Arrays;
import java.util.List;


public class BuilderUtil {

    public  Pet buildFullDataPet(Integer id, String name, String photoUrl,
                                Category category, List<Tag> tags, Status status ){
        return Pet.builder()
                .id(id)
                .name(name)
                .photoUrl(photoUrl)
                .category(Category.builder().id(id).name(name).build())
                .tags(Arrays.asList(Tag.builder().id(id).name(name).build()))
                .status(status)
                .build();
    }
}
