import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileDownloader {
    private String vidURL = "";
    private String outputDirectory = "C:\\Users\\Administrator\\.vscode\\code\\Music Player\\Music Player\\MusicPlayer\\src";

    public FileDownloader(String vidURL) {
        this.vidURL = vidURL;
    }

    public void downloadAudio() {
        ProcessBuilder processBuilder = new ProcessBuilder("yt-dlp", 
        "-x", 
        "--audio-format", "wav", 
        "-o", outputDirectory,
        vidURL);

        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            
            System.out.println(line);
            

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Download complete!");
            } else {
                System.err.println("Process failed with code: " + exitCode);
            }
        }

        catch(IOException | InterruptedException e) {
            System.out.println("Error occured!");
        }

    }      
}
