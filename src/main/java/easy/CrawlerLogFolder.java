package easy;

public class CrawlerLogFolder {
    /*
    The Leetcode file system keeps a log each time some user performs a change folder operation.

    The operations are described below:

            "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
            "./" : Remain in the same folder.
    "x/" : Move to the child folder named x (This folder is guaranteed to always exist).

    You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

    The file system starts in the main folder, then the operations in logs are performed.
    */


    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
    }


    public static int minOperations(String[] logs) {

        int depth=0;
        for (String log:logs){

            if (log.equals("./")) continue;
            else if (log.equals("../")) depth--;
            else depth++;

            if (depth<0) depth=0;
        }
        return depth;
    }
}
