package hus.oop.mynumbersystem;

public class HexadecimalConverter extends AbstractNumberSystemConverter {
    public HexadecimalConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        int intNumber = Integer.parseInt(decimal);
        while (intNumber != 0) {
            int remainder = intNumber % 16;
            intNumber /= 16;

            switch (remainder) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9:
                    sb.append(remainder);
                    break;
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
                    break;
                default:
                    break;

            }
        }
        return sb.reverse().toString();
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
     * Hiển thị số ra terminal theo định dạng a1a2...an(16).
     */
    @Override
    public void display() {
        /* TODO */
        String hex = this.decimalTo(this.convertedNumber);
        System.out.println(hex + "(16)");
    }
}
