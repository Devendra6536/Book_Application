package com.bookapplication.bookapplication.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "/home/team/devendra/JavaBackendDevelopment/SpringbootProjects/bookapplication/src/main/resources/static/image";
    /*
     * public String UPLOAD_DIR = new
     * ClassPathResource("static/image/").getFile().getAbsolutePath();
     * 
     * public FileUploadHelper() throws IOException {
     * 
     * }
     */

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean fileupload_status = false;

        try {

            /* This is first method to upload the file */
            /*
             * InputStream is = multipartFile.getInputStream();
             * byte data[] = new byte[is.available()];
             * is.read(data);
             * FileOutputStream fos = new FileOutputStream(
             * upload_dir + File.separator + multipartFile.getOriginalFilename());
             * fos.write(data);
             * fos.flush();
             * fileupload_status = true;
             * 
             * fos.close();
             */

            /* This is the second method to upload the file */

            /*
             * Files.copy(multipartFile.getInputStream(),
             * Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
             * StandardCopyOption.REPLACE_EXISTING);
             */
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            fileupload_status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileupload_status;

    }
}
