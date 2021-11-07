package test.Cred;
import builders.OrderStatus;
import builders.Status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCred {

    //pet
    public static int PET_CATEGORY_ID = 2;
    public static String PET_CATEGORY_NAME = "Dog";
    public static int PET_ID = 345;
    public static String PET_NAME = "Rocky";
    public static String PET_PHOTO = "https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg";
    public static Status PET_STATUS = Status.available;
    public static int PET_TAG_ID = 13;
    public static String PET_TAG_NAME = "Hound";
    public static Status UPDATED_PET_STATUS = Status.sold;

    //order
    public static int ORDER_ID = 25;
    public static int ORDER_QUANTITY = 3;
    public static String ORDER_SHIP_DATE = getDateAndTime();
    public static OrderStatus ORDER_STATUS = OrderStatus.placed;


    private static String getDateAndTime() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        return dateFormat.format(currentDate);
    }

}
