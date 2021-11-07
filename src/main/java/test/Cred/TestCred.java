package test.Cred;
import builders.OrderStatus;
import builders.Status;

import java.util.Date;

public class TestCred {

    public static int PET_CATEGORY_ID = 2;
    public static String PET_CATEGORY_NAME = "Dog";
    public static int PET_ID = 345;
    public static String PET_NAME = "Rocky";
    public static String PET_PHOTO = "https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg";
    public static Status PET_STATUS = Status.available;
    public static int PET_TAG_ID = 13;
    public static String PET_TAG_NAME = "Hound";
    public static Status UPDATED_PET_STATUS = Status.sold;


    public static int ORDER_ID = 25;
    public static int ORDER_QUANTITY = 3;
    public static Date ORDER_SHIP_DATE = new Date();
    public static OrderStatus ORDER_STATUS = OrderStatus.placed;

}
