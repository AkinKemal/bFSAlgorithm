public class Graph {

    public int numberOfVertices = 0;
    public int numberOfEdges = 0;
    public int[][] adjMatrix = null;

    /*
    numberOfVertices: graph'ın kaç adet düğümü olduğunu tutar.
    numberOfEdges: graph'ın kaç adet kenarı (edge) olduğunu tutar.
    adjMatrix: düğümler arasındaki bağlantıları (edge'leri) tutmak için kullanılan adjacency matrix.
     */

    // Yeni bir Graph nesnesi oluşturur ve numberOfVertices ve adjMatrix değerlerini belirler.
    public Graph(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Number of vertices must be positive");
        }
        adjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        numberOfVertices = size;
    }

    // addEdge(int from, int to): Verilen iki düğüm arasında bir kenar (edge) oluşturur
    // ve adjacency matrix'de bu kenarın varlığını işaretler.
    // Ayrıca numberOfEdges değişkenini 1 arttırır.
    public void addEdge(int from, int to) {
        if (from < 0 && from > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (from vertex):" + from);
        }
        if (to < 0 && to > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (to vertex):" + to);
        }
        adjMatrix[from][to] = 1;
        adjMatrix[to][from] = 1;
        numberOfEdges++;
    }

    // neighbors(int v): Verilen düğüme (v) bitişik olan düğümleri listeler
    // ve bu düğümlerin indekslerini bir string olarak döndürür.
    public String neighbors(int v) {
        if (v < 0 && v > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (v vertex):" + v);
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numberOfVertices; i++) {

            if (adjMatrix[v][i] == 1) {
                str.append(i).append(" ");
            }
        }
        return str.toString();
    }

    // degree(int vertexNo): Verilen düğümün (vertexNo) derecesini (degree) hesaplar.
    // Derece, o düğüme bağlı olan kenar sayısıdır.
    public int degree(int vertexNo) {
        if (vertexNo < 0 && vertexNo > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (vertexNo):" + vertexNo);
        }
        int degree = 0;
        for (int i = 0; i < numberOfVertices; i++) {

            if (adjMatrix[vertexNo][i] == 1) {
                degree++;
            }
        }
        return degree;
    }

    // isEdge(int v, int w): Verilen iki düğüm arasında bir kenarın var olup olmadığını kontrol eder.
    // Eğer kenar varsa true, yoksa false döndürür.
    public boolean isEdge(int v, int w) {
        if (v < 0 && v > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (v vertex):" + v);
        }
        if (w < 0 && w > numberOfVertices) {
            throw new IllegalArgumentException("Number must be in valid range (w vertex):" + w);
        }
        return adjMatrix[v][w] == 1 && adjMatrix[w][v] == 1;
    }

}