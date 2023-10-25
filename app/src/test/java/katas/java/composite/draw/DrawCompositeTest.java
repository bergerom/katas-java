package katas.java.composite.draw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DrawCompositeTest {
    @Test
    public void testDrawComposite() {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Picture pictureInPicture = new Picture();
        List<Component> components = List.of(circle, rectangle, pictureInPicture);
        Picture picture = new Picture(components);
        System.out.println(picture.drawAll());
    }
}
