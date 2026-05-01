package java_learn.javaCollection;

import java.util.PriorityQueue;

// add in the back in the list and remove in the front of the list
public class TestPriorityQues {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);

        /// ye hepify karta default min rheta haigreater wala uppar rhega 
        /// agagr main 5 dala uske baad 2 dala toh less hai toh left mai jeyga
        /// agar main 8 dala toh 5 se bada hai toh right mai jeyga 
        /// phin heafiy hoga jo bada hai wo uppar rhega aur chota niche rhega

        for (Object object : pq) {
            System.out.println(object);
        }
    }
}
