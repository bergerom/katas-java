package katas.java.composite.draw;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Picture implements Component {
    List<Component> components = new ArrayList<>();
    public Picture(List<Component> components) {
        this.components.addAll(components);
    }

    public Picture() {}

    public String drawAll() {
        return components.stream().map(Component::draw).collect(Collectors.joining());
    }
    @Override
    public String draw() {
        return "[~~~o~~~]";
    }
}
