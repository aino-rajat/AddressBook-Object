package backend;

public class FileBackend implements Backend {
	
	private String path;

	@Override
	public String toString() {
		return "FileBackend [path=" + path + "]";
	}
	public FileBackend(int i, String string) {
		super();
	}
    public FileBackend() {
    	super();
    }
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}