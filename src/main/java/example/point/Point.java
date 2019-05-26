package example.point;

import example.CalculateResult;

public class Point implements CalculateResult {
    private Integer point;

    public Point(Integer point) {
        assert point != null && point >= 0;
        this.point = point;
    }

    public int getPoint() {
        return this.point;
    }
}
