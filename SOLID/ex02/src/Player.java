public class Player {
    DecodingService decodingService = new DecodingService();
    UIRenderer uiRenderer = new UIRenderer();
    FrameCache frameCache = new FrameCache();

    void play(byte[] fileBytes){
        // decode
        Frame f = decodingService.decode(fileBytes);
        // draw ui
        uiRenderer.render(f);
        // cache
        frameCache.cache(f);
    }
}