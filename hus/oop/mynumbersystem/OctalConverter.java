package hus.oop.mynumbersystem;

public class OctalConverter extends AbstractNumberSystemConverter {
    public OctalConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
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
            int remainder = intNumber / 8;
            str.append(remainder);
            intNumber /= 8;
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
        this.convertedNumber = decimalTo(number.getNumberPresentation());
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        /* TODO */
        String octal = this.decimalTo(this.convertedNumber);
        System.out.println(octal + "(8)");
    }
}
