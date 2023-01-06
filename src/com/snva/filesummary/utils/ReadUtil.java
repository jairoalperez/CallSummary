package com.snva.filesummary.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadUtil {

    private BufferedReader reader;

    public ReadUtil() {
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * This function reads an string value from the console and converts
     * it to the integer value.
     * @param usermsg This is the message for the user to enter integer value.
     * @param warningmsg This message is raised if the user wants to enter
     * anything other than the integer value.
     * @return Val. Returns an integer value.
     * @exception NumberFormatException.Thrown to indicate that the application
     * has attempted to convert a string to one of the numeric types, but that
     * the string does not have the appropriate format.
     * @exception IOException.Exceptions produced by failed or interrupted I/O operations
     */
    public int readInt(String usermsg,String warningmsg)
    {
        int val=0;
        System.out.println(usermsg);
        try {
            val=Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("enter valid value");
            val=readInt(usermsg, warningmsg);
        } catch (IOException e) {
            System.out.println("Values cannot be read");
        }
        return val;
    }

    /**
     * This function reads an string value from the console.
     * @param usermsg This is the message for the user to enter string value.
     * @param warningmsg This message is raised if the user wants to enter
     * an empty string.
     * @return str. String is returned.
     * @exception IOException.Exceptions produced by failed or interrupted I/O operations
     */
    public String readString(String usermsg,String warningmsg)
    {
        String str="";
        try {
            System.out.println(usermsg);
            str=reader.readLine();
            if(str.trim().length()== 0)
            {
                System.out.println(warningmsg);
                str=readString(usermsg,warningmsg);
            }
        }catch(IOException e){
            System.out.println("values cannot be read");
        }
        return str;

    }

}
