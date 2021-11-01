package test.Cred;

import builders.Category;
import builders.Status;
import builders.Tag;

import java.util.Arrays;
import java.util.List;

public class TestCred {

    public static Category PET_CATEGORY = Category.builder().id(245).name("Dog").build();
    public static Integer PET_ID = 245;
    public static String PET_NAME = "Rocky";
    public static String PET_PHOTO = "https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg";
    public static Status PET_STATUS = Status.available;
    public static List<Tag> PET_TAGS = Arrays.asList(Tag.builder().id(245).name("Hound").build());


    public static List<Tag> UPDATED_PET_TAGS = Arrays.asList(Tag.builder().id(245).name("Sporting").build());



}
