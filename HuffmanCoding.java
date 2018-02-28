//Sharmistha S. Gupta
//2016193

import java.io.*;
import java.util.*;


public class HuffmanCoding {
    public static void main(String[] args) throws IOException {


        // Initialise readers
        Reader.init(System.in);

        // Taking input
        int x = Reader.nextInt(); //width
        int y = Reader.nextInt(); //height

        // Required data structure initialisation
        // 256 because the range of greyscale value is between 0 and 256
        PriorityQueue pq = new PriorityQueue(256);

        // to store freq if (j != (i * 10 + 2) && frequency[j] > 0) {uency for each greyscale value in the image
        int[] frequency = new int[256];

        TreeNode[] array = new TreeNode[256];
        HuffmanTree huffmanTree = new HuffmanTree();

        // Reading image pixels
        for (int i = 0; i < x * y; i++) {
            int temp = Reader.nextInt();
            frequency[temp]++;
        }


        /*
        PART 1
         */
        printCode(x,y,frequency,array,pq, huffmanTree);

        /*
        PART 2 started
         */

        PriorityQueue pq1 = new PriorityQueue(256);
        HuffmanTree huffmanTree1 = new HuffmanTree();

        // Quantization of frequency
        for (int i = 0; i <= 24; i += 1) {
            if (i != 24) {
                for (int j = i * 10; j <= i * 10 + 9; j++) {
                    if (j != (i * 10 + 2) && frequency[j] > 0) {
                        frequency[i * 10 + 2] += frequency[j];
                        frequency[j] = 0;
                    }
                }
            } else {
                for (int j = i * 10; j <= i * 10 + 15; j++) {
                    if (j != (i * 10 + 2) && frequency[j] > 0) {
                        frequency[i * 10 + 2] += frequency[j];
                        frequency[j] = 0;
                    }
                }
            }

        }

        printCode(x,y,frequency,array,pq1, huffmanTree1);

    }

    static void printCode(int x, int y, int arr[],  TreeNode[] array, PriorityQueue pq, HuffmanTree huffmanTree){

        if (x == 1 && y == 1) {
            // corner case
            System.out.println(8.0);
        } else {
            int ptr1 = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    array[ptr1] = new TreeNode(arr[i]);
                    pq.insert(array[ptr1]);
                    ptr1++;
                }
            }

            if (pq.size() == 1) {
                System.out.println(8.0);
            } else {
                huffmanTree.insert_tree(pq);
                huffmanTree.countbits(pq.peek(), 0);

                float compression_ratio = (float) ((x * y * 8.0) / (huffmanTree.total));
                System.out.println((float) (Math.round(compression_ratio * 10)) / 10);
            }
        }
    }
}


/**
 * Reader Class template for taking input from the terminal
 */
class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}