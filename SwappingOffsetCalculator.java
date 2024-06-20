public class SwappingOffsetCalculator {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("SwappingOffsetCalculator (page_size) (offset)");
            System.exit(1);
        }

        try {
            int pageSize = Integer.parseInt(args[0]);
            int offset = Integer.parseInt(args[1]);
            if (pageSize <= 0 || offset < 0) {
                throw new NumberFormatException();
            }

            int[] result = calculatePageOffset(pageSize, offset);
            int pageNumber = result[0];
            int offsetValue = result[1];

            System.out.println("Page Number: " + pageNumber + ", Offset Value: " + offsetValue);
        } catch (NumberFormatException e) {
            System.out.println("Error: Page size must be positive number and offset must be non-negative integer.");
            System.exit(1);
        }
    }

    public static int[] calculatePageOffset(int pageSize, int offset) {
        int pageNumber = offset / pageSize;
        int offsetValue = offset % pageSize;
        return new int[]{pageNumber, offsetValue};
    }
}
