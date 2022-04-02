import Dijkstra.Dijkstra;
import Dijkstra.Graph;
import Dijkstra.Node;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 7, 9, 13, 124, 80};
        int[] arr2 = new int[]{8, 5, 2, 6, 9, 3, 1, 4, 0, 7, 22};
//        System.out.println(binarySearch(arr2, 22));
//        System.out.println(binarySearchRecursive(arr1, 80));
//        Util.printArray(arr2);
//        Algorithm.quicksort(arr2, 0, arr2.length-1);
//        Util.printArray(arr2);
//        selectionSort(arr2);
//        printArray(arr2);
//        System.out.println(factorial(5));
//        System.out.println(countElements(arr1));
//        System.out.println(sum(arr1));
//        System.out.println(findMax(arr1));
//        System.out.println(countElements(arr2));
//        System.out.println(sum(arr2));
//        System.out.println(findMax(arr2));

//        Person janusz = new Person("Janusz");
//        Person patrycja = new Person("Patrycja");
//        Person tamara = new Person("Tamara");
//        Person jarek = new Person("Jarek");
//        Person cecylia = new Person("Cecylia", new Person[]{tamara, jarek});
//        Person alicja = new Person("Alicja", new Person[]{patrycja});
//        Person bartek = new Person("Bartek", new Person[]{janusz, patrycja});
//        Person michal = new Person("Michał", new Person[]{alicja, bartek, cecylia});
//
//        Algorithm.breadthFirstSearch(michal);
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeF, 1);
        nodeD.addDestination(nodeE, 2);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

    }
}