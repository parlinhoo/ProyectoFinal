package main.ScaleLib;

import javax.swing.*;
import java.awt.*;

public class ScaleFrame extends JPanel {
    private Dim2 Size = Dim2.zero;
    private Dim2 Position = Dim2.zero;
    private Vector2<Float> AnchorPoint = Vector2.zeroF;

    public Dim2 getDimSize() {
        return this.Size;
    }

    public Dim2 getPosition() {
        return this.Position;
    }

    public Vector2<Float> getAnchorPoint() {
        return this.AnchorPoint;
    }

    public void setSize(Dim2 size) {
        this.Size = size;
        this.refresh();
    }

    public void setPosition(Dim2 position) {
        this.Position = position;
        this.refresh();
    }

    public void setAnchorPoint(Vector2<Float> vector2) {
        this.AnchorPoint = vector2;
        this.refresh();
    }

    public void refresh() {
        Container parent = this.getParent();
        if (parent == null || parent.getLayout() != null) return;
        int width = this.Size.Offset.X + (int) (parent.getWidth() * this.Size.Scale.X);
        int height = this.Size.Offset.Y + (int) (parent.getHeight() * this.Size.Scale.Y);
        this.setSize(width, height);
        int posX = this.Position.Offset.X + (int) (parent.getWidth() * this.Position.Scale.X) - (int) (this.getWidth() * AnchorPoint.X);
        int posY = this.Position.Offset.Y + (int) (parent.getHeight() * this.Position.Scale.Y) - (int) (this.getHeight() * AnchorPoint.Y);
        this.setLocation(posX, posY);
    }

    public Component add(ScaleFrame comp) {
        Component local = super.add(comp);
        comp.refresh();
        return local;
    }

    @Override
    public void paint(Graphics g) {
        this.refresh();
        super.paint(g);
    }
}
