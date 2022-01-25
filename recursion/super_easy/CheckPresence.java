package recursion.super_easy;

public class CheckPresence {
    public static void main(String[] args) {

    }

    static int checkPresence(int arr[], int index, int searchElem) {
        --index;
        if (index == -1) {
            return -1;
        }
        if (arr[index] == searchElem) {
            return index;
        }
        return checkPresence(arr, index, searchElem);
    }
}
