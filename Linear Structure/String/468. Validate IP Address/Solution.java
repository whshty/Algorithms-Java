import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        System.out.println(validIPAddress("192.168.1.1:2869"));
        
        
    }
    public static boolean validIPAddress(String IP) {
        String[] strs = IP.split(":");
        boolean address = strs[0].matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])");
        boolean port = false;
        if( strs[1].matches("[0-9]+") && strs[1].length() > 0){
            int portNum = Integer.parseInt(strs[1]);
            if( portNum >=0 && portNum <= 65535 ) port = true;
        }
        return address && port;
    }
}
