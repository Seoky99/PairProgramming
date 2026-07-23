public class EBook extends Book implements Borrowable {

    private double fileSizeMB;

    public EBook(String title, String author, double fileSizeMB) {
        super(title, author);
        this.fileSizeMB = fileSizeMB;

    }

    @Override
    public void borrowItem(){

        if (!isBorrowed()) {
            downloadBook(fileSizeMB);
            setBorrowed(true);

            System.out.println("Borrowed Book " + getTitle());

        }
    }

    @Override
    public void returnItem(){
        if (isBorrowed()) {
            setBorrowed(false);
            System.out.println("Return Book " + getTitle());
        }
    }

    private void downloadBook(double fileSizeInMB) {
        if (fileSizeInMB <= 0) {
            throw new IllegalArgumentException("File size must be positive");
        }

        try {
            System.out.println("Downloading " + fileSizeInMB + " MB...");
            Thread.sleep(2000);
            System.out.println("Download complete");
        } catch (InterruptedException e) {
            System.out.println("Download interrupted");
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | File Size: " + this.fileSizeMB + "MB";
    }
}
