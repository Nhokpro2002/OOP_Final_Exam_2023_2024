package hus.oop.vector;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        /* TODO */
       data = new double[DEFAULT_CAPACITY];
        size = data.length;
    }

    public MyArrayVector(int n) {
        data = new double[n];
        size = n;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        return data[index];
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        return data;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        data[index] = value;
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector mới.
     */
    public MyArrayVector add(double value) {
        /* TODO */
        MyArrayVector newArrayVector = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            newArrayVector.data[i] = this.data[i] + value;
        }
        return newArrayVector;
    }

    /**
     * Cộng các phần tử vector hiện tại với các phần tử vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector mới.
     */
    public MyArrayVector add(MyVector another) {
        /* TODO */
        MyArrayVector newArrayVector = new MyArrayVector();
        double[] doubleArray = another.coordinates();
        if (this.size != another.size()) {
            System.out.println("2 vectors khong cung so chieu");
        }
        else {
            for (int i = 0; i < this.size; i++) {
                newArrayVector.data[i] = this.data[i] + doubleArray[i];
            }
        }
        return newArrayVector;
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector addTo(double value) {
        /* TODO */
       double[] newDoubleArray = new double[size];
       for (int i = 0; i< newDoubleArray.length; i++) {
           newDoubleArray[i] = this.data[i] + value;
       }
       this.data = newDoubleArray;
       return this;
    }

    /**
     * Cộng các phần tử vector hiện tại với các phần tử vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector hiện tại.
     */
    public MyArrayVector addTo(MyVector another) {
        /* TODO */
        double[] newArrayDouble = new double[size];
        if (this.size != another.size()) {
            System.out.println("2 vectors khong cun so chieu");
        }
        else {
            for (int i = 0; i < this.size; i++) {
                newArrayDouble[i] = this.data[i] + another.coordinate(i);
            }
        }
        this.data = newArrayDouble;
        return this;
    }

    /**
     * Trừ các phần tử của vector cho giá trị value.
     * @return vector mới.
     */
    public MyArrayVector minus(double value) {
        /* TODO */
        MyArrayVector newArrayVector = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            newArrayVector.data[i] = this.data[i] - value;
        }
        return newArrayVector;
    }

    /**
     * Trừ các phần tử của vector hiện tại cho các phần tử của vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector mới.
     */
    public MyArrayVector minus(MyVector another) {
        /* TODO */
        MyArrayVector newArrayVector = new MyArrayVector();
        double[] doubleArray = another.coordinates();
        if (this.size != another.size()) {
            System.out.println("2 vectors khong cung so chieu");
        }
        else {
            for (int i = 0; i < this.size; i++) {
                newArrayVector.data[i] = this.data[i] - doubleArray[i];
            }
        }
        return newArrayVector;
    }

    /**
     * Trừ các phần tử của vector cho giá trị value.
     * @return vector hiện tại.
     */
    public MyArrayVector minusFrom(double value) {
        /* TODO */
        double[] newDoubleArray = new double[size];
        for (int i = 0; i< newDoubleArray.length; i++) {
            newDoubleArray[i] = this.data[i] - value;
        }
        this.data = newDoubleArray;
        return this;
    }

    /**
     * Trừ các phần tử của vector hiện tại cho các phần tử của vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyArrayVector minusFrom(MyVector another) {
        /* TODO */
        double[] newArrayDouble = new double[size];
        if (this.size != another.size()) {
            System.out.println("2 vectors khong cun so chieu");
        }
        else {
            for (int i = 0; i < this.size; i++) {
                newArrayDouble[i] = this.data[i] - another.coordinate(i);
            }
        }
        this.data = newArrayDouble;
        return this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public double dot(MyVector another) {
        /* TODO */
        double sum = 0;
        if (this.size != another.size()) {
            System.out.println("2 vectors khong cun so chieu");
        }
        else {
            for (int i = 0; i < this.size; i++) {
                sum = this.data[i] + another.coordinate(i);
            }
        }
        return sum;
    }

    /**
     * Các phần tử của vector được lấy mũ power.
     * @param power
     * @return vector hiện tại.
     */
    public MyArrayVector pow(double power) {
        /* TODO */
        double[] newArrayDouble = new double[size];
            for (int i = 0; i < this.size; i++) {
                newArrayDouble[i] = Math.pow(this.data[i], power);
            }

        this.data = newArrayDouble;
        return this;
    }

    /**
     * Các phần tử của vector được nhân với value.
     * @return vector hiện tại.
     */
    public MyArrayVector scale(double value) {
        /* TODO */
        double[] newArrayDouble = new double[size];
        for (int i = 0; i < this.size; i++) {
            newArrayDouble[i] = this.data[i] * value;
        }

        this.data = newArrayDouble;
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
            sum += Math.pow(this.data[i], 2);
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value) {
        /* TODO */
        double[] newDoubleArray = new double[size + 1];
        System.arraycopy(data, 0, newDoubleArray, 0,  data.length);
        newDoubleArray[size] = value;
        data = newDoubleArray;
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value, int index) {
        /* TODO */
        double[] newDoubleArray = new double[size + 1];
        System.arraycopy(data, 0, newDoubleArray, 0, index - 1);
        for (int i = index + 1; i < size + 1; i++) {
            newDoubleArray[i] = data[i - 1];
        }
        data = newDoubleArray;
        size++;
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector remove(int index) {
        /* TODO */
        double[] newDoubleArray = new double[size - 1];
        System.arraycopy(data, 0, newDoubleArray, 0, index - 1);
        for (int i = index + 1; i < size - 1; i++) {
            newDoubleArray[i] = data[i + 1];
        }
        data = newDoubleArray;
        size--;
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     * @param indices
     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
     */
    public MyArrayVector extract(int[] indices) {
        /* TODO */
        MyArrayVector newArrayVector = new MyArrayVector();
        for (int i = 0; i < indices.length; i++) {
            if ( indices[i] >= 0 && indices[i] < data.length) {
                newArrayVector.insert(data[indices[i]]);
            }
            else {
                throw new IllegalArgumentException("Index out of bounds: " + indices[i]);
            }
        }
        return newArrayVector;
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     * @return vector hiện tại.
     */
    private MyArrayVector enlarge() {
        /* TODO */
        double[] newArray = new double[size * 2];
        System.arraycopy(data, 0, newArray, 0, size);
        data = newArray;
        return this;
    }
}
