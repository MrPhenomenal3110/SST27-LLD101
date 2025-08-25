public class FrameCache {
    private Frame lastFrame;
    
    public void cache(Frame frame) {
        this.lastFrame = frame;
        System.out.println("Cached last frame? " + (lastFrame != null));
    }
}