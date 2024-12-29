package hus.oop.mynumbersystem;

public class BinaryConverter extends AbstractNumberSystemConverter {
    public BinaryConverter(ANumber aNumber) {
        super(aNumber);
        this.convertedNumber = decimalTo(aNumber.getNumberPresentation());
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        StringBuilder binary = new StringBuilder();
        int intNumber = Integer.parseInt(decimal);

        // Euclid's algorithm for base conversion
        while (intNumber != 0) {
            int remainder = intNumber % 2; // Calculate remainder
            binary.append(remainder);
            intNumber /= 2; // Update quotient
        }

        return binary.reverse().toString(); // Reverse to get correct binary order
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    @Override
    public void update(ANumber number) {
        this.convertedNumber = decimalTo(number.getNumberPresentation());
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        System.out.println(this.convertedNumber + "(2)");
    }
}
