public class DecodingService {
    public Frame decode(byte[] fileBytes) {
        return new Frame(fileBytes);
    }
}
