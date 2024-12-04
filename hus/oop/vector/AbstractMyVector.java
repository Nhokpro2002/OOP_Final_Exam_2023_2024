package hus.oop.vector;

public abstract class AbstractMyVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        String vector = "[";
        for (int i = 0; i < this.size(); i++) {
            vector += this.coordinate(i) + " ";
            if (i == this.size() - 1) {
                vector += "]";
            }
        }
        return vector;
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng số chiều và có các phần tử bằng nhau.
     * @param another
     * @return
     */
    @Override
    public boolean equals(MyVector another) {
        /* TODO */
       if (this.size() != another.size()) {
           return false;
       }
       else {
           for (int i = 0; i < another.size(); i++) {
               if (this.coordinate(1) != another.coordinate(i)) {
                   return false;
               }
           }
       }
       return true;
    }
}
