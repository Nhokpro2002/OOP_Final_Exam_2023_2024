package hus.oop.mynumbersystem;

public class BinaryConverter extends AbstractNumberSystemConverter {
    public BinaryConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber);
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
        /* TODO */
        StringBuilder str = new StringBuilder();
        int intNumber = Integer.parseInt(decimal);
        while (intNumber != 0) {
            int remainder = intNumber / 2;
            str.append(remainder);
            intNumber /= 2;
        }
        return str.reverse().toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    @Override
    public void update(ANumber number) {
        /* TODO */
        decimalTo(number.getNumberPresentation());
        // Hàm này có thể đang code sai
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
       String bin = this.decimalTo(this.convertedNumber);
        System.out.println(bin + "(2)");
    }

}
