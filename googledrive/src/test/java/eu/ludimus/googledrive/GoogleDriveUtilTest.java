package eu.ludimus.googledrive;

import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.util.List;

public class GoogleDriveUtilTest {

    @org.junit.Test
    public void getFilesUploadedInTheLastNDaysBy() throws IOException {
        List<File> files = GoogleDriveUtil.getFilesUploadedInTheLastNDaysBy(17, "jkkoolen");
        System.out.println(files);
    }
}