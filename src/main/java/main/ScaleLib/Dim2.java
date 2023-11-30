package main.ScaleLib;

public class Dim2 {
    public final Vector2<Integer> Offset;
    public final Vector2<Float> Scale;

    public Dim2(float scaleX, float scaleY, int offsetX, int offsetY) {
        this.Offset = new Vector2<>(offsetX, offsetY);
        this.Scale = new Vector2<>(scaleX, scaleY);
    }
    public Dim2(Vector2<Float> scale, Vector2<Integer> offset) {
        this.Offset = offset;
        this.Scale = scale;
    }


    public static Dim2 getSizeFromScale(float x, float y) {
        return new Dim2(x, y, 0, 0);
    }

    public static Dim2 getSizeFromScale(Vector2<Float> vector2) {
        return new Dim2(vector2.X, vector2.Y, 0, 0);
    }

    public static Dim2 getSizeFromOffset(int x, int y) {
        return new Dim2(0, 0, x, y);
    }

    public static Dim2 getSizeFromOffset(Vector2<Integer> vector2) {
        return new Dim2(0, 0, vector2.X, vector2.Y);
    }

    public static Dim2 zero = new Dim2(0, 0, 0, 0);

    @Override
    public String toString() {
        return String.format("Dim2 (%f %f %d %d)", this.Scale.X, this.Scale.Y, this.Offset.X, this.Offset.Y);
    }
}
