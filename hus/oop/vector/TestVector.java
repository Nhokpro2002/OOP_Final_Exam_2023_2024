package hus.oop.vector;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Arrays;
public class TestVector {

    private static final String OUTPUT_FILE = "NguyenMinhTuan_20000594_Vector.txt";
    public static void main(String[] args) {
        /*
         TODO

         Thực hiện các yêu cầu sau.

         I. Test chức năng vector
           - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
           - Tạo ra các vector có kích thước n, với các phần tử được sinh ngẫu nhiên. Trong đó có 2 vector kiểu MyArrayList
             và 2 vector có kiểu MyListVector.
           - Viết các hàm để test các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
             phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
             đổi vector hoặc tính toán, in kết quả ra terminal.

         II. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
              (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
              <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
         */
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            Random rand = new Random();
            int n = rand.nextInt(10);
            writer.println(n);

            // Create 4 Vectors with dimesion is n
            MyListVector myListVector0 = new MyListVector();
            myListVector0.setSize(n);
            MyListVector myListVector1 = new MyListVector();
            myListVector1.setSize(n);

            //
            //MyArrayVector myArrayVector0 = new MyArrayVector(n);
            //MyArrayVector myArrayVector1 = new MyArrayVector(n);

            //
            for (int i = 0; i < n; i++) {
                myListVector0.insert(rand.nextDouble());
                myListVector1.insert(rand.nextDouble());
                //myArrayVector0.insert(rand.nextDouble());
                //myArrayVector1.insert(rand.nextDouble());
            }
            writer.println(myListVector0.toString());
            writer.println(myListVector1.toString());

            //
            writer.println("Test MyListVector0: ");
            writer.println(myListVector0.size());
            writer.println(myListVector0.add(5));
            writer.println("Sum of 2 vectors:" + myListVector0.add(myListVector1));
            writer.println(myListVector0.coordinate(2));
            writer.println(myListVector0.addTo(3));
            writer.println(Arrays.toString(myListVector0.coordinates()));
            writer.println(myListVector0.dot(myListVector1));
            writer.println(myListVector0.insert(1));
            writer.println(myListVector0.insert(3, 2));
            int[] intArray = {1, 3 , 4};
            writer.println(myListVector0.extract(intArray));
            writer.println(myListVector0.norm());
            writer.println(myListVector0.pow(1.2));
            writer.println(myListVector0.minus(2.4));
            writer.println(myListVector0.minus(myListVector1));
            writer.println(myListVector0.minusFrom(2.33));
            writer.println(myListVector0.minusFrom(myListVector1));

            //
            writer.println();
            writer.println();

            MyArrayVector myArrayVector0 = new MyArrayVector(n);
            MyArrayVector myArrayVector1 = new MyArrayVector(n);
            for (int i = 0; i < n; i++) {
                myArrayVector0.set(rand.nextDouble(), i);
                myArrayVector1.set(rand.nextDouble(), i);
            }

            writer.println(myArrayVector0);
            writer.println(myArrayVector1);

            //
            writer.println(myArrayVector0.add(2));
            writer.println(myArrayVector0.add(myArrayVector1));
            writer.println(myArrayVector0.addTo(3));
            writer.println(myArrayVector0.coordinate(1));
            writer.println(Arrays.toString(myArrayVector0.coordinates()));
            writer.println(myArrayVector0.dot(myArrayVector1));
            writer.println(myArrayVector0.insert(2.5));
            writer.println(myArrayVector0.insert(1.5, 3));
            writer.println(myArrayVector0.minus(4));
            writer.println(myArrayVector0.minusFrom(3));
            writer.println(myArrayVector0.minus(myArrayVector1));
            writer.println(myArrayVector0.norm());
            writer.println(myArrayVector0.pow(3.2));
            writer.println(myArrayVector0.extract(intArray));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
