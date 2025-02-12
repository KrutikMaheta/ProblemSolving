// Pointer's Partition
// Book Read
// Minimizing the maximum number of pages read by a student using binary search.

package ai_searching;

import java.util.Arrays;

public class Ag_PageRead {

    public static void main(String[] args) {
        int arr[] = {10, 5, 6, 9, 2, 8};
        int noOfStudents = 3;
        System.out.println(minimumMaxPageReadByStudent(arr, noOfStudents));
    }

    //  TC: O(n * log(sum(arr)))
    private static int minimumMaxPageReadByStudent(int[] arr, int noOfStudents) {
        int s = Arrays.stream(arr).max().getAsInt();    // Min possible value (largest single book, any one student have to read this book)
        int e = Arrays.stream(arr).sum();               // Max possible value (all books assigned to one student)
        int ans = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            // Check if we can allocate books such that no student reads more than 'm' pages
            if (isPossibleSolution(m, arr, noOfStudents)) {
                ans = m;    // Store the valid answer and try for a better minimum
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }

    private static boolean isPossibleSolution(int maxPages, int[] arr, int noOfStudents) {
        int studentCount = 1;   // Start with one student
        int sum = 0;            // Track the sum of pages assigned to current student

        for (int i = 0; i < arr.length; i++) {
            // If a single book has more pages than 'maxPages', allocation is impossible
            if (arr[i] > maxPages) {
                return false;
            }

            // If adding this book exceeds maxPages, assign to next student
            if (sum + arr[i] > maxPages) {
                studentCount++;     // Allocate to next student
                sum = arr[i];       // Start new sum with this book
                if (studentCount > noOfStudents) {
                    return false;   // More students needed than available
                }
            } else {
                sum += arr[i];  // Continue assigning books to the current student
            }
        }
        return true;
    }

}
