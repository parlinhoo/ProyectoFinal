package main.ScaleLib;

public class Vector2<T> {
    public final T X;
    public final T Y;

    public Vector2(T x, T y) {
        this.X = x;
        this.Y = y;
    }

    public static Vector2<Float> zeroF = new Vector2<>(0f, 0f);
    public static Vector2<Integer> zeroInt = new Vector2<>(0, 0);

    @Override
    public String toString() {
        return String.format("Vector2 (%f %f)", (float) this.X, (float) this.Y);
    }
}
