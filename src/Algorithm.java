import java.util.*;

public class Algorithm {

    public static int binarySearch(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];

            if (guess == item) {
                return mid;
            } else if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = array[i];
            int index = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < smallest) {
                    smallest = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = smallest;
        }
    }

    public static int factorial(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    //4.1 Napisz kod źródłowy wcześniejszej funkcji sum
    public static int sum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        return array[0] + sum(Arrays.stream(array).skip(1).toArray());
    }

    //4.2 Napisz funkcję rekurencyjną liczącą elementy w liście
    public static int countElements(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        return 1 + countElements(Arrays.stream(array).skip(1).toArray());
    }

    //4.3 Znajdź największą liczbę w liście
    public static int findMax(int[] array) {
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        return Math.max(array[0], findMax(Arrays.stream(array).skip(1).toArray()));
    }

    //4.4 Pamiętasz wyszukiwanie binarne z rozdziału 1.? To też algorytm typu "dziel i rządź".
    // Potrafisz określić przypadki bazowy i rekurencyjny dla wyszukiwania binarnego?
    public static int binarySearchRecursive(int[] array, int item) {
        selectionSort(array);
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        int guess = array[mid];

        if (guess == item) {
            return mid;
        } else if (guess > item) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
        Arrays.spliterator(array, low, high);
        return binarySearch(array, item);
    }

    //Sortowanie szybkie (ang. quicksort) to oczywiście algorytm sortowania. Jest
    //znacznie szybszy od sortowania przez wybieranie i dzięki temu powszechnie
    //wykorzystywany w wielu prawdziwych programach.

    public static void quicksort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quicksort(arr, begin, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, end);
        }
    }

    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public static void breadthFirstSearch(Person person) {
        Deque<Person> searchQueue = new ArrayDeque<>();
        searchQueue.add(person);

        while (!searchQueue.isEmpty()) {
            Person checkedPerson = searchQueue.pollFirst();
            if (checkedPerson.isSeller()) {
                System.out.println(checkedPerson.getName() + " sprzedaje mango!");
                return;
            } else {
//                System.out.println(checkedPerson.getName() + " nie sprzedaje mango");
                Arrays.stream(checkedPerson.getFriends()).forEach(p -> {
//                    System.out.println("Dodaję osobę " + p.getName());
                    searchQueue.offerLast(p);
                });
            }
        }
        return;
    }
}
