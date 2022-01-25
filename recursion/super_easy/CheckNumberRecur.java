package recursion.super_easy;

public class CheckNumberRecur {
    public static void main(String[] args) {
        System.out.println(checkPresence(new int[] { 8, 10, 9, 10 }, 3, 10));
        System.out.println(checkPresenceLastIndex(new int[] { 8, -10, 9, 11, -10 }, 5, -10));
        System.out.println(firstIndex(new int[] { 8, -10, 9, 11, -10 }, -10));
    }

    static boolean checkPresence(int arr[], int i, int element) {
        i--;
        if (i == -1) {
            return false;
        }
        if (arr[i] == element) {
            return true;
        }
        return checkPresence(arr, i, element);
    }

    static int checkPresenceLastIndex(int arr[], int index, int searchElem) {
        --index;
        if (index == -1) {
            return -1;
        }
        if (arr[index] == searchElem) {
            return index;
        }
        return checkPresenceLastIndex(arr, index, searchElem);
    }

    static int firstIndex(int arr[], int searchElem) {
        return checkPresenceIndex(arr, 0, searchElem);
    }

    static int checkPresenceIndex(int arr[], int index, int searchElem) {

        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == searchElem) {
            return index;
        }
        return checkPresenceIndex(arr, ++index, searchElem);
    }
}
