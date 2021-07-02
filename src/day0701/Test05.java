package day0701;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author liu yicheng
 * @date 2021/7/1 - 17:15
 */
public class Test05 {

    public static void listfiles(File files, String keyword , List<String> listname){
        File[] res = files.listFiles();
        if (res == null) return;
        for (File re : files.listFiles()) {
            if (re.isDirectory()) listfiles(re, keyword, listname);
            if (re.getName().indexOf(keyword) != -1) listname.add(re.getName());
        }
    }


    public static void main (String [] arg) {

        List<String> listname = new ArrayList<>();

        String path = "d:" + File.separator;
        listfiles(new File(path), "m", listname);

        for (String name : listname) {

            System.out.println(name);

        }


    }
}
