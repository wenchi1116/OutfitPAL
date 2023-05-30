package fourpeople.socute.outfitpal;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageDownload {
    private String imageUrl;

    public ImageDownload(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    void downloadImage() {// 從指定 URL 下載的圖片資料寫入到目標檔案中
        String destinationFile = "outfitpal.jpg"; // 保存到本地的檔案名稱
        try {
            URI uri = URI.create(imageUrl);

            try (InputStream in = new BufferedInputStream(uri.toURL().openStream())) {
                Path destinationPath = Path.of(destinationFile);
                Files.copy(in, destinationPath);
                System.out.println("圖片已成功保存到本地檔案：" + destinationFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("圖片未成功保存到本地檔案：");
        }
    }
}
