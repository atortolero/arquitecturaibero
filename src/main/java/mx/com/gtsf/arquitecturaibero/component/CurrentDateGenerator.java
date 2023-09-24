package mx.com.gtsf.arquitecturaibero.component;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("currentDateGenerator")
public class CurrentDateGenerator {

    public String generateCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String strDate  = dateFormat.format(date); //2016/11/16 12:08:43

        return strDate;
    }

    public String generateCurrentDateWithoutTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String strDate  = dateFormat.format(date); //2020/08/16

        return strDate;
    }
}

