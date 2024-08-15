package Day_1;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
        Java 8 Feature-
        1 DateTimeAPI Example
 */
public class MyDOB {
    public static void main(String[] args) {
        LocalDate currDate = LocalDate.now();
        System.out.println(currDate);
        System.out.println(currDate.getDayOfWeek());
        System.out.println(currDate.getMonth());

        LocalDateTime dateTime= LocalDateTime.now();
        System.out.println(dateTime);

    }
}
