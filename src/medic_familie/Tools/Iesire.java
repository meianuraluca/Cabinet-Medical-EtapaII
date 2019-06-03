package medic_familie.Tools;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Iesire {
    static private String fileName = "serviciuAudit.csv";
    private static Iesire Instance = new Iesire();
    public static Iesire getInstance(){
        return Instance;
    }
    public void addToFile(String comName) {
        File log = new File(fileName);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(log, true));
            StringBuilder sb = new StringBuilder();

            sb.append(comName);
            sb.append(",");
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss ");
            Date date = new Date(System.currentTimeMillis());
            sb.append(formatter.format(date));
            pw.println(sb.toString());
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
