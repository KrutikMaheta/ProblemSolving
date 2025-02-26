//  This program converts an Excel-style column name (e.g., "A", "Z", "AB", "ZY") into its corresponding column number (e.g., 1, 26, 28, 701).


package aa_basicmaths;

public class E_ExcelColumnNo {
    public static void main(String[] args) {
        System.out.println(excelColNo("AB"));
        System.out.println(excelColNo("ZA"));
        System.out.println(excelColNo("ABC"));
    }

    // Observation:
    //  Excel columns work like base-26 numbers, where the leftmost character has the highest place value.
    //  This follows the same logic as converting a base-26 number to a decimal number.
    //  TC: O(N)
    private static int excelColNo(String column) {
        int columnNo = 0;

        // Iterate from left to right, treating it as a base-26 number
        for (int i = 0; i < column.length(); i++) {
            char ch = column.charAt(i);
            columnNo = columnNo * 26 + (ch - 'A' + 1);
        }
        return columnNo;
    }
}
