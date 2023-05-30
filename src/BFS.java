import java.util.ArrayList;

public class BFS {

    /*
    Bu class genişlik öncelikli arama (BFS) algoritmasını kullanarak bir grafın tüm düğümlerini ziyaret eder.
    Program, dosyadan (input.txt) graf verilerini okur,
    bir Graph nesnesi ve bir QueueOperations nesnesi oluşturur.
     */

    ReadFile readFile = new ReadFile();
    Graph graph;
    QueueOperations queueOperations = new QueueOperations();
    ArrayList<QueueNode> controlArraylist = new ArrayList<>();
    /*
    QueueOperations sınıfı, bir kuyruk veri yapısı uygular ve bu kuyruğun öğelerini eklemek, çıkarmak, ön ve arka elemanları kontrol etmek için yöntemler sağlar.
    ArrayList, BFS işleminin kontrolünü sağlamak için kullanılır. BFS sırasında işlenen her düğüm, kontrol listesine eklenir.
    Bu kontrol listesi, daha önce işlenmiş düğümleri kontrol etmek için kullanılır.
     */

    public BFS() {
        create();
    }

    // create() metodu, önce verileri dosyadan okur,
    // sonra Graph yapısını oluşturmak için bir Graph nesnesi oluşturur
    // ve okunan verileri kullanarak bir bağlantı matrisi yapısını doldurur.
    private void create() {
        //dosyadan veri alma
        //verileri list yapısına ekleme
        readFile.readerFromFile("input.txt");
        //graph yapısını oluşturma
        graph = new Graph(readFile.size + 1);
        //matrix yapısını oluşturma
        LinkedListNode walk = readFile.linkedListOperations.getHead();
        while (walk != null) {
            graph.addEdge(walk.getFrom(), walk.getTo());
            walk = walk.getNext();
        }
    }

    // bfsOperation() metodu, BFS algoritmasını uygular ve sonuçları yazdırır.
    // Başlangıç noktası olarak 1 numaralı düğümü kullanır,
    // başlangıç düğümünü bir kuyruğa ekler,
    // daha sonra kuyruktan elemanları çıkarır ve komşu düğümlerini işler.
    // İşlenen düğümler, kontrol edilmek üzere bir kontrol listesine eklenir.
    // Düğümler işlenirken BFS algoritması kullanılarak,
    // her bir komşu düğüme distance+1 uzaklıkta olacak şekilde mesafeler atanır.
    // Sonuçları bir StringBuilder nesnesi kullanarak bir çıktıya ekler ve bu çıktıyı ekrana yazdırır.
    public void bfsOperation() {
        StringBuilder stringBuilderOutput = new StringBuilder();
        //çok önemli
        //ilk elemanı ekleme
        queueOperations.enQueue(1);
        controlArraylist.add(queueOperations.rear);
        while (queueOperations.getFront() != null) {
            int distance = queueOperations.front.getDistance();
            int box = queueOperations.deQueue();
            stringBuilderOutput.append(box).append(" ");
            //komşu vertexleri belirleme
            String str = graph.neighbors(box);
            String[] arraySplit = str.split(" ");
            for (String s : arraySplit) {
                if (comparisonOfElement(s)) {
                    queueOperations.enQueue(Integer.parseInt(s));
                    queueOperations.rear.setDistance((distance + 1));
                    controlArraylist.add(queueOperations.rear);
                }
            }
        }

        System.out.println("Output: " + stringBuilderOutput);
    }

    // comparisonOfElement() metodu, kontrol listesindeki bir elemanın daha önce işlenip işlenmediğini kontrol eder.
    private boolean comparisonOfElement(String str) {
        boolean bool = true;
        for (QueueNode queueNode : controlArraylist) {
            if (queueNode.getNumber() == Integer.parseInt(str)) {
                bool = false;
            }
        }
        return bool;
    }

    public void print() {
        for (QueueNode queueNode : controlArraylist) {
            System.out.println("number: " + queueNode.getNumber() + ", distance: " + queueNode.getDistance() + ", state: " + queueNode.isBool());
        }
    }

}