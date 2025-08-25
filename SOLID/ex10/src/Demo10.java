public class Demo10 {
    public static void main(String[] args) {
        Logger fileLogger = new FileLogger();
        ReportService fileReportService = new ReportService(fileLogger);
        fileReportService.generate();

        Logger consoleLogger = new ConsoleLogger();
        ReportService consoleReportService = new ReportService(consoleLogger);
        consoleReportService.generate();
    }
}
