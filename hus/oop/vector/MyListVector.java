package hus.oop.vector;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
        data = new ArrayList<>();
        size = 0;

    }
    /* TODO */

    @Override
    public int size() {
        return data.size();
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public double coordinate(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Error: Index is out of bounds");
            }
            return data.get(index);
        } catch (IndexOutOfBoundsException e) {
            // Handle the exception and allow the program to continue
            System.out.println(e.getMessage());
            // Return a default value (e.g., 0) to keep the program running
            return 0;
        }
    }


    @Override
    public double[] coordinates() {
        /* TODO */
        double[] doubleArray = new double[data.size()];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = data.get(i);
        }
        return doubleArray;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        data.set(index, value);
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector mới.
     */
    public MyListVector add(double value) {
        // Tạo một vector mới
        MyListVector newListVector = new MyListVector();
        // Lặp qua các phần tử của vector hiện tại
        for (int i = 0; i < data.size(); i++) {
            // Thêm phần tử đã được cộng value vào vector mới
            newListVector.data.add(this.coordinate(i) + value);
        }
        // Cập nhật kích thước của vector mới
        newListVector.setSize(data.size());
        return newListVector;
    }


    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector mới.
     */
    public MyListVector add(MyVector another) {
        /* TODO */
        MyListVector listVector = new MyListVector();
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("2 vectors not have same size");
        }
        else {
            for (int i = 0; i < this.size(); i++) {
                listVector.data.add(this.coordinate(i) + another.coordinate(i));
            }
            listVector.setSize(data.size());
        }
        return listVector;
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector addTo(double value) {
        /* TODO */
        for (int i = 0; i < this.size(); i++) {
            data.set(i, this.coordinate(i) + value);
        }
        return this;
    }

    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector addTo(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) {
            System.out.println("2 vectors khong cung kick co");
        }
        else {
            for (int i = 0; i < data.size(); i++) {
                data.set(i, this.coordinate(i) + another.coordinate(i));
            }
        }
       return this;
    }

    /**
     * Trừ các phần tử của vector cho value.
     * @return vector mới.
     */
    public MyListVector minus(double value) {
        /* TODO */
        MyListVector newListVector = new MyListVector();
        for (int i = 0; i < coordinates().length; i++) {
            newListVector.add(this.coordinate(i) - value);
        }
        newListVector.setSize(data.size());
        return newListVector;
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector mới.
     */
    public MyListVector minus(MyVector another) {
        /* TODO */
        MyListVector listVector = new MyListVector();
        try {
            if (this.size() != another.size()) {
                throw new IllegalArgumentException("Error");
            }
            else {
                for (int i = 0; i < this.size(); i++) {
                    listVector.add(this.coordinate(i) - another.coordinate(i));
                }
                listVector.setSize(data.size());
            }
        }
        catch (IllegalArgumentException e) {
            // Handle the exception and allow the program to continue
            System.out.println(e.getMessage());
            // Return a default value (e.g., 0) to keep the program running
            //return null;
        }
        return listVector;
    }

    /**
     * Trừ các phần tử của vector cho value.
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(double value) {
        /* TODO */
        for (int i = 0; i < this.size(); i++) {
            data.set(i, this.coordinate(i) - value);
        }
        return this;
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(MyVector another) {
        /* TODO */
        try {
            if (this.size() != another.size()) {
                throw new IllegalArgumentException("Vectors must have the same size.");
            }
            for (int i = 0; i < this.size(); i++) {
                data.set(i, this.coordinate(i) - another.coordinate(i));
            }
            return this;
        }
       catch (IllegalArgumentException e) {
           // Handle the exception and allow the program to continue
           System.out.println(e.getMessage());
       }
        return null;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     * @return tích vô hướng.
     */
    public double dot(MyVector another) {
        /* TODO */
        double scalarProduct = 0;
        if (this.size() != another.size()) {
            throw new NoSuchElementException("2 vectors not have same size");
        }
        else {
            for (int i = 0 ; i < another.size(); i++) {
                scalarProduct += this.coordinate(i) * another.coordinate(i);
            }
        }
        return scalarProduct;
    }

    /**
     * Các phần tử vector được lấy mũ power.
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        /* TODO */
        for (int i = 0; i < this.size(); i++) {
           this.set(Math.pow(this.coordinate(i), power),i);
        }
        return this;
    }

    /**
     * Các phần tử vector được nhân với value.
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        /* TODO */
        for (int i = 0; i < this.size(); i++) {
            this.set(this.coordinate(i) * value,i);
        }
        return this;
    }

    /**
     * Lấy chuẩn của vector.
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < this.size(); i++) {
            sum += Math.pow(this.coordinate(i), 2);
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào vector ở vị trí cuối cùng.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        /* TODO */
        data.add(value);
        this.size = data.size();
        return this;
    }

    /**
     * Thêm một giá trị vào vector ở vị trí index.
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        /* TODO */
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index of of bound Array");
            }
            data.add(index, value);
            this.size = data.size();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Error");
        }
        return this;
    }

    /**
     * Xóa phần tử ở vị trí index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        // Kiểm tra nếu chỉ số không hợp lệ
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        // Xóa phần tử tại vị trí chỉ định
        data.remove(index);
        // Giảm kích thước vector
        //size--;
        return this;
    }


    /**
     * Trích xuất ra một vector con của vector ban đầu, có các phần tử
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     * @param indices
     * @return vector mới có kiểu MyListVector có các phần tử được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) {
        /* TODO */
        MyListVector newListVector = new MyListVector();
        for (int index : indices) {
            if (index >= 0 && index < this.size()) {
                newListVector.insert(this.coordinate(index));
            } else {
                throw new IllegalArgumentException("Index out of bounds: " + index);
            }
        }
        newListVector.setSize(data.size());
        return newListVector;
    }
}
