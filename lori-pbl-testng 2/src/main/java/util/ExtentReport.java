//package util;
//
////import com.relevantcodes.extentreports.ExtentReports;
//
//import com.aventstack.extentreports.ExtentReports;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ExtentReport {
//    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
//    public static ExtentReports extent = null;
//
////    /**
////     * It is used to generate html file for extent reports under reports folder.
////     * @throws IOException
////     */
//
//    public void publishReports() throws IOException, IOException {
//        extent = new ExtentReports();
////        Date date = new Date();
////        File dir1 = new File(".");
////        if (System.getenv("ReportName") != null) {
////            String file = dir1.getCanonicalPath() + File.separator + "src" + File.separator + "reports" + File.separator
////                    + System.getenv("ReportName") + ".html";
////            extent = new ExtentReports();
////        } else {
////            String file = dir1.getCanonicalPath() + File.separator + "src" + File.separator + "reports" + File.separator
////                    + "report" + ".html";
////            extent = new ExtentReports();
////
////        }
//    }
//}
