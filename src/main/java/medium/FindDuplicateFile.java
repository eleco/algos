package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFile {

    /*
    Given a list paths of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.

    A group of duplicate files consists of at least two files that have the same content.

    A single directory info string in the input list has the following format:

        "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

    It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

    The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

    "directory_path/file_name.txt"

     */

    public static void main(String[] args) {
        System.out.println(findDuplicate(
                new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"}));
    }


    static List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> m = new HashMap<>();

        for (String p : paths) {
            String []str  = p.split(" ");

            String root= str[0];
            for (int i=1;i<str.length;i++) {
                int start= str[i].indexOf("(");
                String content = str[i].substring(start, str[i].length()-1);
                String fn = str[i].substring(0,start);

                List<String> identicals= m.get(content);
                if (identicals==null)  identicals=new ArrayList<String>();
                identicals.add(root+"/"  +fn);
                m.put(content, identicals );
            }
        }

        List<List<String>> ret = new ArrayList<>();
        for (Map.Entry<String,List<String>> e : m.entrySet()) {
            List<String> l = new ArrayList<>(e.getValue());
            if (l.size()>1) ret.add(l);
        }
        return ret;
    }


}
