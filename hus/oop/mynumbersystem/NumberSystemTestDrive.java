package hus.oop.mynumbersystem;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class NumberSystemTestDrive {
    public static void main(String[] args) {

        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên khác 10 nằm trong đoạn [2, 16] được sinh ngẫu nhiên (nếu sinh ra 10 thì sinh lại).
            - Xâu ký tự biểu diễn số được sinh ra bằng cách:
                + Độ dài số là một số tự nhiên nằm trong đoạn [10, 30] được sinh ra ngẫu nhiên.
                + Mỗi chữ số được sinh ra bằng cách: sinh ra một chỉ số ngẫu nhiên nằm trong đoạn [0, radix - 1],
                  sau đó lấy tương ứng với chỉ số đó một chữ số nằm trong xâu "0123456789ABCDEF".

        - Mỗi lần sinh ra một số và một cơ số mới, thực hiện việc cập nhật và in ra các số được chuyển đổi
          tự động sang các số được biểu diễn trong hệ cơ số 2, 8, 16.

        - Thực hiện chạy chương trình để in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:
          Original number: 123456
          radix 12
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Original number: 456789
          radix 7
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        Random rd = new Random();
        String STRING = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringBuilder numberStringRepresent = new StringBuilder();
            int radix;

            do {
                radix = rd.nextInt(15) + 2; // [2, 16]
            } while (radix == 10);

            int stringLength = rd.nextInt(21) + 10; // [10, 30]

            // Generate a random number string in the specified radix
            for (int j = 0; j < stringLength; j++) {
                int stringIndexJ = rd.nextInt(radix);
                numberStringRepresent.append(STRING.charAt(stringIndexJ));
            }

            String originalNumber = numberStringRepresent.toString();
            result.append("Original number: ").append(originalNumber).append("\n");
            result.append("Radix: ").append(radix).append("\n");

            // Convert the number to binary, octal, and hexadecimal
            BigInteger number = new BigInteger(originalNumber, radix);

            result.append("Binary: ").append(number.toString(2)).append("\n");
            result.append("Octal: ").append(number.toString(8)).append("\n");
            result.append("Hexadecimal: ").append(number.toString(16).toUpperCase()).append("\n\n");
        }

        // Print results to terminal
        System.out.println(result);

        // Write results to a file
        try (FileWriter writer = new FileWriter("NguyenVanA_123456_NumberSystemConverter.txt")) {
            writer.write(result.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
