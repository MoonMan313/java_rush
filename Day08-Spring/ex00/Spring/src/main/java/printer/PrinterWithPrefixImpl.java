package printer;

import renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        this.prefix = "";
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String message) {
        renderer.renderer(prefix + message);
    }
}
